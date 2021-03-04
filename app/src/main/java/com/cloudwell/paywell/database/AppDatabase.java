package com.cloudwell.paywell.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.BusLocalDB;
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.BusSchedule;
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.TripScheduleInfo;
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.airportSearch.search.model.Airport;
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.airticket.flightDetails2.model.Passenger;
import com.cloudwell.paywell.PrePSPVersion.Ui.ticket.busticketNew.model.Transport;
import com.cloudwell.paywell.services.activity.myFavorite.model.FavoriteMenu;
import com.cloudwell.paywell.services.activity.notification.model.NotificationDetailMessage;
import com.cloudwell.paywell.services.activity.notification.notificaitonFullView.model.NotificationDetailMessageSync;
import com.cloudwell.paywell.recentList.model.RecentUsedMenu;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2/1/19.
 */
@Database(entities = {FavoriteMenu.class, NotificationDetailMessage.class, NotificationDetailMessageSync.class, Airport.class, Passenger.class,
        Transport.class, BusLocalDB.class, BusSchedule.class, TripScheduleInfo.class,
//        DESCOHistory.class, DESCOPrepaidHistory.class,DPDCHistory.class,
//        WasaHistory.class, PallibidyutHistory.class, WestZoneHistory.class, IvacHistory.class, BanglalionHistory.class, KarnaphuliHistory.class,
        RecentUsedMenu.class}, version = 6)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FavoriteMenuDab mFavoriteMenuDab();

    public abstract NotificationDab mNotificationDab();

    public abstract AirtricketDab mAirtricketDab();


    public abstract BusTicketDab mBusTicketDab();

}
