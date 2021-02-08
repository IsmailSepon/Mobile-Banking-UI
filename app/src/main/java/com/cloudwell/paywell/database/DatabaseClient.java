package com.cloudwell.paywell.database;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/**
 * Created by Kazi Md. Saidul Email: Kazimdsaidul@gmail.com  Mobile: +8801675349882 on 2/1/19.
 */
public class DatabaseClient {

    private static DatabaseClient mInstance;

    //our app database object
    private AppDatabase appDatabase;

    private static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

            Log.e("migrate", "Start");
            database.execSQL("CREATE TABLE IF NOT EXISTS `NotificationDetailMessage` (`added_datetime` TEXT, `balance_return_data` TEXT, `image_url` TEXT, `message` TEXT, `message_id` TEXT NOT NULL, `message_sub` TEXT, `status` TEXT, `type` TEXT, `message_expiry_time` TEXT, PRIMARY KEY(`message_id`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `NotificationDetailMessageSync` (`message_id` TEXT NOT NULL, PRIMARY KEY(`message_id`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `Airport` (`id` TEXT NOT NULL, `airport_name` TEXT NOT NULL, `city` TEXT NOT NULL, `country` TEXT NOT NULL, `iata` TEXT NOT NULL, `icao` TEXT NOT NULL, `iso` TEXT NOT NULL, `state` TEXT NOT NULL, `time_zone` TEXT NOT NULL, `status` TEXT NOT NULL, PRIMARY KEY(`id`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `Passenger` (`Title` TEXT NOT NULL, `FirstName` TEXT NOT NULL, `LastName` TEXT NOT NULL, `PaxType` TEXT NOT NULL, `DateOfBirth` TEXT NOT NULL, `Gender` TEXT NOT NULL, `PassportNumber` TEXT NOT NULL, `PassportExpiryDate` TEXT NOT NULL, `PassportNationality` TEXT NOT NULL, `CountryCode` TEXT NOT NULL, `Nationality` TEXT NOT NULL, `ContactNumber` TEXT NOT NULL, `Email` TEXT NOT NULL, `IsLeadPassenger` INTEGER NOT NULL, `Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `isPassengerSleted` INTEGER NOT NULL, `Country` TEXT NOT NULL, `passportImagePath` TEXT NOT NULL, `file_extension` TEXT NOT NULL, `visa_extension` TEXT NOT NULL, `visa_content` TEXT NOT NULL, `nid_number` TEXT NOT NULL, `isDefault` INTEGER NOT NULL)");
            Log.e("migrate", "END");

        }
    };

    private static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

            Log.e("migrate", "Start");
            database.execSQL("CREATE TABLE IF NOT EXISTS `NotificationDetailMessage` (`added_datetime` TEXT, `balance_return_data` TEXT, `image_url` TEXT, `message` TEXT, `message_id` TEXT NOT NULL, `message_sub` TEXT, `status` TEXT, `type` TEXT, `message_expiry_time` TEXT, PRIMARY KEY(`message_id`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `NotificationDetailMessageSync` (`message_id` TEXT NOT NULL, PRIMARY KEY(`message_id`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `Airport` (`id` TEXT NOT NULL, `airport_name` TEXT NOT NULL, `city` TEXT NOT NULL, `country` TEXT NOT NULL, `iata` TEXT NOT NULL, `icao` TEXT NOT NULL, `iso` TEXT NOT NULL, `state` TEXT NOT NULL, `time_zone` TEXT NOT NULL, `status` TEXT NOT NULL, PRIMARY KEY(`id`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `Passenger` (`Title` TEXT NOT NULL, `FirstName` TEXT NOT NULL, `LastName` TEXT NOT NULL, `PaxType` TEXT NOT NULL, `DateOfBirth` TEXT NOT NULL, `Gender` TEXT NOT NULL, `PassportNumber` TEXT NOT NULL, `PassportExpiryDate` TEXT NOT NULL, `PassportNationality` TEXT NOT NULL, `CountryCode` TEXT NOT NULL, `Nationality` TEXT NOT NULL, `ContactNumber` TEXT NOT NULL, `Email` TEXT NOT NULL, `IsLeadPassenger` INTEGER NOT NULL, `Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `isPassengerSleted` INTEGER NOT NULL, `Country` TEXT NOT NULL, `passportImagePath` TEXT NOT NULL, `file_extension` TEXT NOT NULL, `visa_extension` TEXT NOT NULL, `visa_content` TEXT NOT NULL, `nid_number` TEXT NOT NULL, `isDefault` INTEGER NOT NULL)");


            Log.e("start version 3", "Start");
            database.execSQL("CREATE TABLE IF NOT EXISTS `Transport` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `busid` TEXT NOT NULL, `busname` TEXT NOT NULL, `extraCharge` REAL NOT NULL)");
            database.execSQL("CREATE TABLE IF NOT EXISTS `BusLocalDB` (`busID` TEXT NOT NULL, `bus_col_in_middle` TEXT NOT NULL, `bus_is_ac` TEXT NOT NULL, `columns_in_right` TEXT NOT NULL, `empty_rows_in_left` TEXT NOT NULL, `empty_rows_in_middle` TEXT NOT NULL, `empty_rows_in_right` TEXT NOT NULL, `name` TEXT NOT NULL, `seat_structure` TEXT NOT NULL, `structure_type` TEXT NOT NULL, `total_columns` TEXT NOT NULL, `total_rows` TEXT NOT NULL, `total_seats` TEXT NOT NULL, PRIMARY KEY(`busID`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `BusSchedule` (`_schedule_Id` TEXT NOT NULL, `schedule_time` TEXT NOT NULL, `bus_id` TEXT NOT NULL, `coach_no` TEXT NOT NULL, `schedule_type` TEXT NOT NULL, `_validity_date` TEXT NOT NULL, `ticket_price` TEXT NOT NULL, `allowed_seat_numbers` TEXT NOT NULL, `booth_departure_info` TEXT NOT NULL, PRIMARY KEY(`_schedule_Id`))");
            database.execSQL("CREATE TABLE IF NOT EXISTS `TripScheduleInfo` (`from_location` TEXT NOT NULL, `to_location` TEXT NOT NULL, `schedule_Id` TEXT NOT NULL, `validity_date` TEXT NOT NULL, PRIMARY KEY(`schedule_Id`))");
            Log.e("migrate", "END");

        }
    };

    private static final Migration MIGRATION_3_4 = new Migration(3, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {

            updateMigration(database);

        }
    };

    private static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `TripScheduleInfo` (`from_location` TEXT NOT NULL, `to_location` TEXT NOT NULL, `schedule_Id` TEXT NOT NULL, `validity_date` TEXT NOT NULL, PRIMARY KEY(`schedule_Id`))");
        }
    };




    private static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `DESCOPrepaidHistory` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bill_number` TEXT NOT NULL, `payer_phone_number` TEXT NOT NULL, `date` TEXT NOT NULL)");
            database.execSQL("CREATE UNIQUE INDEX `index_DESCOPrepaidHistory_bill_number_payer_phone_number` ON `DESCOPrepaidHistory` (`bill_number`, `payer_phone_number`)");
            database.execSQL("CREATE TABLE IF NOT EXISTS `RecentUsedMenu` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `category` TEXT NOT NULL, `icon` TEXT NOT NULL, `favorite_list_position` INTEGER NOT NULL, `alias_key` INTEGER NOT NULL)");


        }
    };


    private static final Migration MIGRATION_1_6 = new Migration(1, 6) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            updateMigration(database);
        }
    };


    private static void updateMigration(SupportSQLiteDatabase database) {
        Log.e("migrate", "Start");
        database.execSQL("CREATE TABLE IF NOT EXISTS `NotificationDetailMessage` (`added_datetime` TEXT, `balance_return_data` TEXT, `image_url` TEXT, `message` TEXT, `message_id` TEXT NOT NULL, `message_sub` TEXT, `status` TEXT, `type` TEXT, `message_expiry_time` TEXT, PRIMARY KEY(`message_id`))");
        database.execSQL("CREATE TABLE IF NOT EXISTS `NotificationDetailMessageSync` (`message_id` TEXT NOT NULL, PRIMARY KEY(`message_id`))");
        database.execSQL("CREATE TABLE IF NOT EXISTS `Airport` (`id` TEXT NOT NULL, `airport_name` TEXT NOT NULL, `city` TEXT NOT NULL, `country` TEXT NOT NULL, `iata` TEXT NOT NULL, `icao` TEXT NOT NULL, `iso` TEXT NOT NULL, `state` TEXT NOT NULL, `time_zone` TEXT NOT NULL, `status` TEXT NOT NULL, PRIMARY KEY(`id`))");
        database.execSQL("CREATE TABLE IF NOT EXISTS `Passenger` (`Title` TEXT NOT NULL, `FirstName` TEXT NOT NULL, `LastName` TEXT NOT NULL, `PaxType` TEXT NOT NULL, `DateOfBirth` TEXT NOT NULL, `Gender` TEXT NOT NULL, `PassportNumber` TEXT NOT NULL, `PassportExpiryDate` TEXT NOT NULL, `PassportNationality` TEXT NOT NULL, `CountryCode` TEXT NOT NULL, `Nationality` TEXT NOT NULL, `ContactNumber` TEXT NOT NULL, `Email` TEXT NOT NULL, `IsLeadPassenger` INTEGER NOT NULL, `Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `isPassengerSleted` INTEGER NOT NULL, `Country` TEXT NOT NULL, `passportImagePath` TEXT NOT NULL, `file_extension` TEXT NOT NULL, `visa_extension` TEXT NOT NULL, `visa_content` TEXT NOT NULL, `nid_number` TEXT NOT NULL, `isDefault` INTEGER NOT NULL)");


        Log.e("start version 3", "Start");
        database.execSQL("CREATE TABLE IF NOT EXISTS `Transport` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `busid` TEXT NOT NULL, `busname` TEXT NOT NULL, `extraCharge` REAL NOT NULL)");
        database.execSQL("CREATE TABLE IF NOT EXISTS `BusLocalDB` (`busID` TEXT NOT NULL, `bus_col_in_middle` TEXT NOT NULL, `bus_is_ac` TEXT NOT NULL, `columns_in_right` TEXT NOT NULL, `empty_rows_in_left` TEXT NOT NULL, `empty_rows_in_middle` TEXT NOT NULL, `empty_rows_in_right` TEXT NOT NULL, `name` TEXT NOT NULL, `seat_structure` TEXT NOT NULL, `structure_type` TEXT NOT NULL, `total_columns` TEXT NOT NULL, `total_rows` TEXT NOT NULL, `total_seats` TEXT NOT NULL, PRIMARY KEY(`busID`))");
        database.execSQL("CREATE TABLE IF NOT EXISTS `BusSchedule` (`_schedule_Id` TEXT NOT NULL, `schedule_time` TEXT NOT NULL, `bus_id` TEXT NOT NULL, `coach_no` TEXT NOT NULL, `schedule_type` TEXT NOT NULL, `_validity_date` TEXT NOT NULL, `ticket_price` TEXT NOT NULL, `allowed_seat_numbers` TEXT NOT NULL, `booth_departure_info` TEXT NOT NULL, PRIMARY KEY(`_schedule_Id`))");
        database.execSQL("CREATE TABLE IF NOT EXISTS `TripScheduleInfo` (`from_location` TEXT NOT NULL, `to_location` TEXT NOT NULL, `schedule_Id` TEXT NOT NULL, `validity_date` TEXT NOT NULL, PRIMARY KEY(`schedule_Id`))");

        Log.e("start version 4", "Start");
        database.execSQL("CREATE TABLE IF NOT EXISTS `DESCOHistory`(`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bill_number` TEXT NOT NULL, `payer_phone_number` TEXT NOT NULL, `date` TEXT NOT NULL)");
        database.execSQL("CREATE UNIQUE INDEX `index_DESCOHistory_bill_number_payer_phone_number` ON `DESCOHistory` (`bill_number`, `payer_phone_number`)");

        database.execSQL("CREATE TABLE IF NOT EXISTS `DPDCHistory` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bill_number` TEXT NOT NULL, `payer_phone_number` TEXT NOT NULL, `location` TEXT NOT NULL, `date` TEXT NOT NULL)");
        database.execSQL("CREATE UNIQUE INDEX `index_DPDCHistory_bill_number_payer_phone_number_location` ON `DPDCHistory` (`bill_number`, `payer_phone_number`, `location`)");

        database.execSQL("CREATE TABLE IF NOT EXISTS `WasaHistory` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bill_number` TEXT NOT NULL, `payer_phone_number` TEXT NOT NULL, `date` TEXT NOT NULL)");
        database.execSQL("CREATE UNIQUE INDEX `index_WasaHistory_bill_number_payer_phone_number` ON `WasaHistory` (`bill_number`, `payer_phone_number`)");

        database.execSQL("CREATE TABLE IF NOT EXISTS `PallibidyutHistory` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bill_number` TEXT NOT NULL, `date` TEXT NOT NULL)");
        database.execSQL("CREATE UNIQUE INDEX `index_PallibidyutHistory_bill_number` ON `PallibidyutHistory` (`bill_number`)");

        database.execSQL("CREATE TABLE IF NOT EXISTS `WestZoneHistory` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bill_number` TEXT NOT NULL, `payer_phone_number` TEXT NOT NULL, `date` TEXT NOT NULL)");
        database.execSQL("CREATE UNIQUE INDEX `index_WestZoneHistory_bill_number_payer_phone_number` ON `WestZoneHistory` (`bill_number`, `payer_phone_number`)");

        database.execSQL("CREATE TABLE IF NOT EXISTS `IvacHistory` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `payer_phone_number` TEXT NOT NULL, `date` TEXT NOT NULL)");
        database.execSQL("CREATE UNIQUE INDEX `index_IvacHistory_payer_phone_number` ON `IvacHistory` (`payer_phone_number`)");

        database.execSQL("CREATE TABLE IF NOT EXISTS `BanglalionHistory` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `customer_number` TEXT NOT NULL, `date` TEXT NOT NULL)");
        database.execSQL("CREATE UNIQUE INDEX `index_BanglalionHistory_customer_number` ON `BanglalionHistory` (`customer_number`)");


        database.execSQL("CREATE TABLE IF NOT EXISTS `KarnaphuliHistory` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bill_number` TEXT NOT NULL, `payer_phone_number` TEXT NOT NULL, `date` TEXT NOT NULL)");
        database.execSQL("CREATE UNIQUE INDEX `index_KarnaphuliHistory_bill_number_payer_phone_number` ON `KarnaphuliHistory` (`bill_number`, `payer_phone_number`)");

        database.execSQL("CREATE TABLE IF NOT EXISTS `DESCOPrepaidHistory` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bill_number` TEXT NOT NULL, `payer_phone_number` TEXT NOT NULL, `date` TEXT NOT NULL)");
        database.execSQL("CREATE UNIQUE INDEX `index_DESCOPrepaidHistory_bill_number_payer_phone_number` ON `DESCOPrepaidHistory` (`bill_number`, `payer_phone_number`)");


        Log.e("start version 6", "Start");
        database.execSQL("CREATE TABLE IF NOT EXISTS `RecentUsedMenu` (`Id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `category` TEXT NOT NULL, `icon` TEXT NOT NULL, `favorite_list_position` INTEGER NOT NULL, `alias_key` INTEGER NOT NULL)");


        Log.e("migrate", "END");
    }

    public static synchronized DatabaseClient getInstance(Context mCtx) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(mCtx);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }

    private DatabaseClient(Context mCtx) {
        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase.class, DatabaseConstant.KEY_PARNELL_DATABASE_NAME)
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4,MIGRATION_4_5,MIGRATION_5_6, MIGRATION_1_6)
                .build();
    }
}