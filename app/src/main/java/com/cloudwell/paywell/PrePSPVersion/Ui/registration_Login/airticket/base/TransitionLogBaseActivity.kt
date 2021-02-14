package com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.base

import android.Manifest
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.text.InputType
import android.text.method.PasswordTransformationMethod
import android.view.Gravity
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.FileProvider
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.bookingCencel.BookingCancelActivity
import com.cloudwell.paywell.R
import com.cloudwell.paywell.app.AppHandler
import com.cloudwell.paywell.constant.AllConstant
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.booking.model.Datum
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.bookingStatus.fragment.PriceChangeFragment
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.bookingStatus.fragment.TicketActionMenuFragment
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.bookingStatus.fragment.TicketStatusFragment
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.bookingStatus.fragment.TricketChooserFragment
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.bookingStatus.model.BookingStatuViewStatus
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.bookingStatus.model.ResIssueTicket
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.bookingStatus.viewModel.BookingStatsViewModel
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.ticketCencel.TicketCancelActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.ticketViewer.TicketViewerActivity
import com.cloudwell.paywell.PrePSPVersion.Ui.registration_Login.airticket.ticketViewer.emailTicket.PassengerEmailSendListActivity
import com.cloudwell.paywell.data.preferences.AppStorageBox
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.orhanobut.logger.Logger
import java.io.File

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2019-04-28.
 */
open class TransitionLogBaseActivity : AirTricketBaseActivity() {

    var limit: Int = 0
    lateinit var mViewMode: BookingStatsViewModel

    var pinNumber: String = ""
    var bookingId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }


    fun initViewModel() {
        mViewMode = ViewModelProviders.of(this).get(BookingStatsViewModel::class.java)

        mViewMode.baseViewStatus.observe(this, Observer {
            handleViewCommonStatus(it)
        })

//        mViewMode.mViewStatus.observe(this, Observer {
//            it?.let { it1 -> handleViewStatus(it1) }
//        })
    }



    fun showActionMenuPopupMessate(model: Datum) {
//        model.message = "Ticketed"

        AppStorageBox.put(applicationContext, AppStorageBox.Key.BOOKING_STATUS_ITEM, model)


        val tricketChooserFragment = TicketActionMenuFragment()

        tricketChooserFragment.setOnClickHandlerTest(object : TicketActionMenuFragment.OnClickHandler {

            override fun onReissue(item: Datum) {

                TicketCancelActivity.model = item
                val intent = Intent(applicationContext, TicketCancelActivity::class.java)
                intent.putExtra(TicketCancelActivity.KEY_TITLE, AllConstant.Action_reIssueTicket)
                startActivity(intent)


            }

            override fun onTicketRefund(item: Datum) {
                TicketCancelActivity.model = item
                val intent = Intent(applicationContext, TicketCancelActivity::class.java)
                intent.putExtra(TicketCancelActivity.KEY_TITLE, AllConstant.Action_Refund)
                startActivity(intent)

            }


            override fun onTicketVoid(item: Datum) {

                TicketCancelActivity.model = item
                val intent = Intent(applicationContext, TicketCancelActivity::class.java)
                intent.putExtra(TicketCancelActivity.KEY_TITLE, AllConstant.Action_Void)
                startActivity(intent)

            }

            override fun onDocsUpdate(item: Datum) {
                val mAppHandler = AppHandler.getmInstance(applicationContext)
                val userName = mAppHandler.userName
                callCancelMapping(userName, item.bookingId!!, "", AllConstant.Action_DOCS_UPDATE, item)
            }

            override fun onIsisThicket() {
                model.bookingId?.let {
                    bookingId = it
                    askForPin(it, AllConstant.Action_IsisThicket)
                }
            }

            override fun onBookingCancel() {
                val model = AppStorageBox.get(applicationContext, AppStorageBox.Key.BOOKING_STATUS_ITEM) as Datum

                val intent = Intent(applicationContext, BookingCancelActivity::class.java)
                intent.putExtra(BookingCancelActivity.KEY_BOOKING_ID, model.bookingId)
                startActivity(intent)


            }
        })

        tricketChooserFragment.show(supportFragmentManager, "dialog")
    }


    public fun showThicketIntentPopupMessage(datum: Datum) {


        val tricketChooserFragment = TricketChooserFragment()
        tricketChooserFragment.datum = datum

        tricketChooserFragment.setOnClickHandlerTest(object : TricketChooserFragment.OnClickHandler {
            override fun onClick(s: String) {
                if (s.equals("view")) {
                    downloadPDFFile(datum.invoiceUrl)
                } else if (s.equals("view_with_fare")) {
                    downloadPDFFile(datum.invoiceUrlWithFare)
                }else if (s.equals("email")) {
                    openSendEmailActivity(datum)
                }
            }

        })

        tricketChooserFragment.show(supportFragmentManager, "dialog")
    }

    private fun openSendEmailActivity(datum: Datum) {

        AppStorageBox.put(applicationContext, AppStorageBox.Key.BOOKING_STATUS_ITEM, datum)

        val intent = Intent(this, PassengerEmailSendListActivity::class.java)
        startActivity(intent)


    }

    private fun downloadPDFFile(url: String) {

        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                        if (report.areAllPermissionsGranted()) {

                            try {
                                if (isInternetConnection) {
                                    handlePDFDownload(url)
                                } else {
                                    showNoInternetConnectionFound()
                                }
                            } catch (e: java.lang.Exception) {
                                Toast.makeText(applicationContext, getString(R.string.please_try_again), Toast.LENGTH_LONG).show()
                                dismissProgressDialog()
                            }


                        } else {

                        }
                    }

                    override fun onPermissionRationaleShouldBeShown(permissions: List<PermissionRequest>, token: PermissionToken) {
                        token.continuePermissionRequest()
                    }
                }).check()
    }

    private fun handlePDFDownload(invoiceUrl: String) {
        val dir = File(Environment.getExternalStorageDirectory().toString() + File.separator + "PayWell/")
        dir.mkdirs()

        val split = invoiceUrl.toString().split("/")
        val fileName = split.last()

        val pdfFile = File(dir.absolutePath, fileName)
        downloadAndOpenPdf(invoiceUrl, pdfFile)
    }

    fun downloadAndOpenPdf(url: String, file: File) {
        if (!file.isFile()) {

            showProgressDialog()

            val dm = getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
            val req = DownloadManager.Request(Uri.parse(url))
            req.setDestinationUri(Uri.fromFile(file))
            req.setTitle("Some title")

            val receiver = object : BroadcastReceiver() {
                override fun onReceive(context: Context, intent: Intent) {
                    dismissProgressDialog()

                    unregisterReceiver(this)
                    if (file.exists()) {
                        openPdfDocument(file, url)
                    }
                }
            }
            registerReceiver(receiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
            dm.enqueue(req)
            Toast.makeText(this, "Download started", Toast.LENGTH_SHORT).show()
        } else {
            openPdfDocument(file, url)
        }
    }

    fun openPdfDocument(file: File, url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        try {

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                intent.setDataAndType(Uri.parse(file.absolutePath), "application/pdf")
            } else {
                var uri = Uri.parse(file.absolutePath)
                //val file = File(uri.path!!)
                if (file.exists()) {

                    uri = FileProvider.getUriForFile(applicationContext, applicationContext.getPackageName() + ".provider", file)
                    intent.setDataAndType(uri, "application/pdf")
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
            }

            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)

        } catch (e: Exception) {
            Logger.e("" + e.message)

            openPDFWebView(url)

        }

    }

    private fun openPDFWebView(url: String) {
        if (isInternetConnection) {
            val intent = Intent(this, TicketViewerActivity::class.java)
            intent.putExtra("url", url)
            startActivity(intent)
        } else {
            showNoInternetConnectionFound()
        }

    }


    public fun showMsg(msg: String) {
        val t = TicketStatusFragment()
        TicketStatusFragment.message = msg
        t.show(supportFragmentManager, "dialog")


    }

    fun showTicketPriceChangeDialog(modelPriceChange: ResIssueTicket) {


        val priceChangeFragment = PriceChangeFragment()
        priceChangeFragment.modelPriceChange = modelPriceChange

        priceChangeFragment.setOnClickHandlerTest(object : PriceChangeFragment.OnClickHandler {
            override fun onClickActionIssueTicket() {
                mViewMode.issueTicket(isInternetConnection, pinNumber, bookingId, true)
            }
        })

        priceChangeFragment.show(supportFragmentManager, "dialog")


    }


    fun askForPin(bookingId: String, action: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.pin_no_title_msg)

        val pinNoET = EditText(this)
        val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT)
        pinNoET.gravity = Gravity.CENTER_HORIZONTAL
        pinNoET.layoutParams = lp
        pinNoET.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_TEXT_VARIATION_PASSWORD
        pinNoET.transformationMethod = PasswordTransformationMethod.getInstance()
        builder.setView(pinNoET)

        builder.setPositiveButton(R.string.okay_btn) { dialogInterface, id ->
            val inMethMan = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inMethMan.hideSoftInputFromWindow(pinNoET.windowToken, 0)

            if (pinNoET.text.toString().length != 0) {
                dialogInterface.dismiss()
                pinNumber = pinNoET.text.toString().trim()

                if (action.equals(AllConstant.Action_IsisThicket)) {
                    mViewMode.issueTicket(isInternetConnection, pinNumber, bookingId, false)
                } else if (action.equals(AllConstant.Action_reIssueTicket)) {
                    mViewMode.issueTicket(isInternetConnection, pinNumber, bookingId, false)
                }


            } else {
                showMsg(getString(R.string.pin_no_error_msg))

            }
        }
        builder.setNegativeButton(R.string.cancel) { dialogInterface, i -> dialogInterface.dismiss() }
        val alert = builder.create()
        alert.show()
    }

    fun handleViewStatus(it: BookingStatuViewStatus) {
        if (it.isShowProcessIndicatior) {
            showProgressDialog()
        } else {
            dismissProgressDialog()
        }
        if (!it.successMessageTricketStatus.equals("")) {
            showMsg(it.successMessageTricketStatus)
        }

        if (it.modelPriceChange != null) {
            showTicketPriceChangeDialog(it.modelPriceChange!!)
        }

    }
}
