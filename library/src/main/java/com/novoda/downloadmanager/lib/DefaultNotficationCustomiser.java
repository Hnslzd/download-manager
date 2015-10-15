package com.novoda.downloadmanager.lib;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.novoda.downloadmanager.Download;
import com.novoda.downloadmanager.R;

class DefaultNotficationCustomiser implements NotificationCustomiser {

    private final Context context;

    public DefaultNotficationCustomiser(Context context) {
        this.context = context;
    }

    @Override
    public void modifyQueuedOrDownloadingNotification(NotificationCompat.Builder builder, Download download) {
        Intent cancelIntent = DownloadManager.createCancelBatchIntent(download.getId(), context);
        PendingIntent pendingCancelIntent = PendingIntent.getBroadcast(context, 0, cancelIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.addAction(R.drawable.dl__ic_action_cancel, context.getString(R.string.dl__cancel), pendingCancelIntent);
    }

}
