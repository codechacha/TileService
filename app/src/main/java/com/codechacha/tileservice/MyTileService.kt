package com.codechacha.tileservice

import android.os.Build
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.util.Log
import androidx.annotation.RequiresApi

@RequiresApi(api = Build.VERSION_CODES.N)
class MyTileService : TileService() {

    override fun onTileAdded() {
        Log.d(TAG, "onTileAdded()")

        qsTile.state = Tile.STATE_INACTIVE
        qsTile.updateTile()
    }

    override fun onTileRemoved() {
        Log.d(TAG, "onTileRemoved()")
    }

    override fun onStartListening() {
        Log.d(TAG, "onStartListening(): " + qsTile.label)
    }

    override fun onStopListening() {
        Log.d(TAG, "onStopListening(): " + qsTile.label)
    }

    override fun onClick() {
        Log.d(TAG, "onClick()")
        when (qsTile.state) {
            Tile.STATE_ACTIVE -> {
                Log.d(TAG, "Current State is STATE_ACTIVE. change to STATE_INACTIVE")
                qsTile.state = Tile.STATE_INACTIVE
            }
            Tile.STATE_INACTIVE -> {
                Log.d(TAG, "Current State is STATE_INACTIVE. change to STATE_ACTIVE")
                qsTile.state = Tile.STATE_ACTIVE
            }
            Tile.STATE_UNAVAILABLE -> {
                Log.d(TAG, "Current State is STATE_UNAVAILABLE")
            }
        }
        qsTile.updateTile()

        Log.d(TAG, "isLocked: $isLocked")
    }

    companion object {
        val TAG = MyTileService::class.java.simpleName
    }
}

