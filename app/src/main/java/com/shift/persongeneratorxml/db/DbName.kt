package com.shift.persongeneratorxml.db

import android.provider.BaseColumns

object DbName: BaseColumns {
    const val TABLE_NAME = "Persons"
    //const val COLUMN_NAME_TITLE = "title"
    //const val COLUMN_NAME_SUBTITLE = "subtitle"
    const val COLUMN_KEY = "key"
    const val COLUMN_NAME = "name"
    const val COLUMN_EMAIL = "email"
    const val COLUMN_BIRTHDAY = "birthday"
    const val COLUMN_ADDRESS = "address"
    const val COLUMN_NUMBER = "number"
    const val COLUMN_PASSWORD = "password"
    const val COLUMN_THUMBNAIL = "thumbnail"
    const val COLUMN_PICTURE = "picture"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "Person.db"

    const val CREATE_TABLE =
        "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
                "${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_KEY TEXT,"+
                " $COLUMN_NAME TEXT, $COLUMN_EMAIL TEXT, $COLUMN_BIRTHDAY TEXT,"+
                " $COLUMN_ADDRESS TEXT, $COLUMN_NUMBER TEXT, $COLUMN_PASSWORD TEXT,"+
                " $COLUMN_THUMBNAIL TEXT, $COLUMN_PICTURE TEXT,)"

    const val DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}