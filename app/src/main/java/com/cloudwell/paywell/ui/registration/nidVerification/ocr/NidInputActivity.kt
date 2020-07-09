package com.cloudwell.paywell.ui.registration.nidVerification.ocr

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.cloudwell.paywell.R
import com.cloudwell.paywell.databinding.ActivityOldNidPageBinding
import com.cloudwell.paywell.ui.BaseActivity
import com.cloudwell.paywell.ui.registration.nidVerification.ocr.model.RegistrationModel
import com.cloudwell.paywell.ui.registration.nidVerification.ocr.nidOCR.model.User
import com.cloudwell.paywell.ui.registration.nidVerification.ocr.nidOCR.view.IInputNidListener
import com.cloudwell.paywell.ui.registration.nidVerification.ocr.nidOCR.viewModel.InputNidModelFactory
import com.cloudwell.paywell.ui.registration.nidVerification.ocr.nidOCR.viewModel.NidInputViewModel
import com.cloudwell.paywell.utils.ImageUtility.getResizedBitmap
import com.cloudwell.paywell.utils.viewUtil.toast
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView
import kotlinx.android.synthetic.main.content_nid_input.*
import java.io.ByteArrayOutputStream

class NidInputActivity : BaseActivity(), IInputNidListener {

    private var isNID = false
    private var isMissingPage = false
    private val authViewModelFactory: InputNidModelFactory? = null


    lateinit var inputViewModel: NidInputViewModel
    var regModel: RegistrationModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_old_nid_page)

        val binding: ActivityOldNidPageBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_old_nid_page
        )

        if (regModel == null) {
            regModel = RegistrationModel()
        }

        inputViewModel =
            ViewModelProviders.of(this, authViewModelFactory).get(NidInputViewModel::class.java)
        binding.viewmode = inputViewModel
        inputViewModel.iView = this


        isNID = intent.getBooleanExtra("isNID", false)
        if (isNID) {
            setToolbar(getString(R.string.title_nid))
        } else {
            setToolbar(getString(R.string.title_smart))
        }

        isMissingPage = intent.getBooleanExtra("isMissingPage", false)

        ivNidFirst.setOnClickListener {
            inputViewModel.isFirstPage = true
            openCropActivity()

        }

        ivNidSecound.setOnClickListener {
            inputViewModel.isFirstPage = false
            openCropActivity()
        }

        btNext.setOnClickListener {
            inputViewModel.onNextClick(applicationContext, isNID)
        }

    }


    private fun openCropActivity() {
        Dexter.withActivity(this)
            .withPermissions(
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            .withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {

                    if (report.areAllPermissionsGranted()) {
                        CropImage.activity(inputViewModel.photoURI1)
                            .setGuidelines(CropImageView.Guidelines.ON)
                            .start(this@NidInputActivity)
                    } else {

                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest>,
                    token: PermissionToken
                ) {
                }
            }).check()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode == Activity.RESULT_OK) {

                val resultUri = result.uri
                if (inputViewModel.isFirstPage) {

                    inputViewModel.firstPageUri = resultUri
                    ivNidFirst.setImageURI(resultUri)
                    ivForntSeleted.visibility = View.VISIBLE
                } else {
                    inputViewModel.secoundPageUri = resultUri
                    ivNidSecound.setImageURI(resultUri)
                    ivBackSeleted.visibility = View.VISIBLE
                }


            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                val error = result.error
            }
        }

    }


    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hiddenProgress() {
        progressBar.visibility = View.GONE
    }


//    override fun onFailure(message: String) {
//        toast(message)
//    }

    override fun noInternetConnectionFound() {
        toast("No internet connection found!!!")
    }

    override fun onFailure(message: String?) {
        toast(message!!)
    }


    override fun openNextActivity(user: User) {

        if (isNID) {

            // here you will get captured or selected image<br>
            val nidFirst = BitmapFactory.decodeFile(inputViewModel.firstPageUri.path)
            regModel?.nidFront = encodeTobase64(nidFirst)

            val nidSecound = BitmapFactory.decodeFile(inputViewModel.secoundPageUri.path)
            regModel?.nidBack = encodeTobase64(nidSecound)

        } else {
            val nidFirst = BitmapFactory.decodeFile(inputViewModel.firstPageUri.path)
            regModel?.smartCardFront = encodeTobase64(nidFirst)

            val nidSecound = BitmapFactory.decodeFile(inputViewModel.secoundPageUri.path)
            regModel?.smartCardBack = encodeTobase64(nidSecound)
        }


//        val intent = Intent(applicationContext, InputNidInfoActivity::class.java)
//        intent.putExtra("data", Gson().toJson(user))
//        intent.putExtra("isNID", isNID)
//        intent.putExtra("isMissingPage", isMissingPage)
//        startActivity(intent)

    }

    override fun setDefaultNIDImagInFirstNIDView() {
        ivNidFirst.setImageResource(R.drawable.nid_pic)
        ivForntSeleted.visibility = View.GONE

    }

    override fun setDefaultNIDImagInSecondNIDView() {
        ivNidSecound.setImageResource(R.drawable.nid_pic_2)
        ivBackSeleted.visibility = View.GONE


    }


    fun encodeTobase64(image: Bitmap?): String {
        val baos = ByteArrayOutputStream()
        val myBm: Bitmap = getResizedBitmap(image, 1000, 700)
        myBm.compress(Bitmap.CompressFormat.JPEG, 50, baos)
        val b = baos.toByteArray()
        val imageEncoded = Base64.encodeToString(b, Base64.DEFAULT).replace("[\n\r]".toRegex(), "")
        val strBuild = "xxCloud" + imageEncoded + "xxCloud"
        return strBuild
    }


}