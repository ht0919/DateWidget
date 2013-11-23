package cx.ath.digiwrite.datewidget;

import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;
import android.text.format.Time;

public class DateWidget extends AppWidgetProvider {

	private String getDate() {
		String day[] = {"日","月","火","水","木","金","土"};
		Time time = new Time("Asia/Tokyo");
		time.setToNow();
		String date = time.year + "年" + (time.month+1) + "月" + time.monthDay + "日\n" + day[time.weekDay] + "曜日";
		return date;
	}

	@Override
	public void onUpdate(Context c, AppWidgetManager awm, int[] awi) {
		super.onUpdate(c, awm, awi);

		String date = getDate();

		// ～　リモートビューにmain.xmlをセット　～//
		RemoteViews rv = new RemoteViews(c.getPackageName(), R.layout.main);
		rv.setTextViewText(R.id.textView, date);
		// ～　ウィジェットにremoteViewsをセット　～//
		ComponentName cn = new ComponentName(c, DateWidget.class);
		awm.updateAppWidget(cn, rv);
	}
}
