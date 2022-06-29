package com.example.campingwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class AppWidget extends AppWidgetProvider {

    @Override
    //AppWidget that extends to the main application and thus the online booking forum.
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            //standard android widget layout
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,0);
            //calling the widget UI such that when you click you have an action performed
            RemoteViews view = new RemoteViews(context.getPackageName(),R.layout.camping_widget);
            view.setOnClickPendingIntent(R.id.camping_button,pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId, view);

        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}
