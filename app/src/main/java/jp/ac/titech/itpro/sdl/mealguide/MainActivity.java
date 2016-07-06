package jp.ac.titech.itpro.sdl.mealguide;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends Activity implements CompoundButton.OnCheckedChangeListener{
    //グローバル変数
    Globals globals;
    ArrayList<ArrayList<Globals.restaurant>> List = new ArrayList<ArrayList<Globals.restaurant>>();

    //スイッチの状態変数
    int[] isSwitchOn = {0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setActionBar((Toolbar)findViewById(R.id.toolbar));

        //グローバル変数の取得と初期化
        globals = (Globals) this.getApplication();
        globals.AllInit();
        List.add(globals.China);
        List.add(globals.Ramen);
        List.add(globals.Curry);
        List.add(globals.Set);
        List.add(globals.Italy);
        List.add(globals.Fashion);
        List.add(globals.Any);

        //マップボタンの実装
        Button mapButton = (Button) findViewById(R.id.mapbutton);
        mapButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(globals.All.size() != 0) {
                    Intent intent = new Intent(getApplication(), MapActivity.class);
                    startActivity(intent);
                }else{
                    final Context context = getApplicationContext();
                    final CharSequence text = "希望を選択して、候補を更新してからマップに移行してください。";
                    final int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        //ウェブボタンの実装
        Button webButton = (Button) findViewById(R.id.webbutton);
        webButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                globals.nowUrl = "https://www.google.co.jp/";
                Intent intent = new Intent(getApplication(), WebActivity.class);
                startActivity(intent);
            }
        });

        Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(this);
        Switch switch2 = (Switch) findViewById(R.id.switch2);
        switch2.setOnCheckedChangeListener(this);
        Switch switch3 = (Switch) findViewById(R.id.switch3);
        switch3.setOnCheckedChangeListener(this);
        Switch switch4 = (Switch) findViewById(R.id.switch4);
        switch4.setOnCheckedChangeListener(this);
        Switch switch5 = (Switch) findViewById(R.id.switch5);
        switch5.setOnCheckedChangeListener(this);
        Switch switch6 = (Switch) findViewById(R.id.switch6);
        switch6.setOnCheckedChangeListener(this);
        Switch switch7 = (Switch) findViewById(R.id.switch7);
        switch7.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){
        if(isChecked == true){
            switch(buttonView.getId()){
                case R.id.switch1:isSwitchOn[0] = 1;break;
                case R.id.switch2:isSwitchOn[1] = 1;break;
                case R.id.switch3:isSwitchOn[2] = 1;break;
                case R.id.switch4:isSwitchOn[3] = 1;break;
                case R.id.switch5:isSwitchOn[4] = 1;break;
                case R.id.switch6:isSwitchOn[5] = 1;break;
                case R.id.switch7:isSwitchOn[6] = 1;break;
            }
        }else{
            switch(buttonView.getId()){
                case R.id.switch1:isSwitchOn[0] = 0;break;
                case R.id.switch2:isSwitchOn[1] = 0;break;
                case R.id.switch3:isSwitchOn[2] = 0;break;
                case R.id.switch4:isSwitchOn[3] = 0;break;
                case R.id.switch5:isSwitchOn[4] = 0;break;
                case R.id.switch6:isSwitchOn[5] = 0;break;
                case R.id.switch7:isSwitchOn[6] = 0;break;
            }
        }
    }

    //決定ボタンを押したときの処理
    //チェックの入っている種別のレストランをAllに追加
    public void onClickDecideButton(View v){
        globals.All.clear();
        if(isSwitchOn[6] == 1){ //なんでもいいがonなので全てのレストランをAllに追加する
            for(int i = 0; i < List.size(); i++){
                globals.All.addAll(List.get(i));
            }
        }else {
            for (int i = 0; i < isSwitchOn.length - 1; i++) {
                if (isSwitchOn[i] == 1) {
                    globals.All.addAll(List.get(i));
                }
            }
        }
        //定休日の店を削除する
        Calendar cal = Calendar.getInstance();
        switch (cal.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SUNDAY:
                for(int i = 0; i < globals.All.size();){
                    if(globals.All.get(i).getName() == "麺でる真紅" || globals.All.get(i).getName() == "だいにんぐらく" || globals.All.get(i).getName() == "九絵" || globals.All.get(i).getName() == "東工大生協第二食堂") globals.All.remove(i);
                    else i++;
                }
                break;
            case Calendar.MONDAY:
                for(int i = 0; i < globals.All.size();){
                    if(globals.All.get(i).getName() == "麺屋こころ") globals.All.remove(i);
                    else i++;
                }
                break;
            case Calendar.TUESDAY:
                for(int i = 0; i < globals.All.size();){
                    if(globals.All.get(i).getName() == "ひるがお") globals.All.remove(i);
                    else i++;
                }
                break;
            case Calendar.FRIDAY:
                for(int i = 0; i < globals.All.size();){
                    if(globals.All.get(i).getName() == "やぶそば") globals.All.remove(i);
                    else i++;
                }
                break;
            case Calendar.SATURDAY:
                for(int i = 0; i < globals.All.size();){
                    if(globals.All.get(i).getName() == "東工大生協第二食堂") globals.All.remove(i);
                    else i++;
                }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("候補を更新しました。\n変更が無ければマップへ移行してください。")
                .setTitle("更新完了！")
                .setPositiveButton("OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id){
                final Context context = getApplicationContext();
                final CharSequence text = "「マップへ移行」ボタンを押してマップに移行しよう";
                final int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
        builder.show();
        System.out.println("候補レストランの要素数は " + globals.All.size() +  " 個です。");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { //メニューの配置
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {   //メニューの動作
        int id = item.getItemId();

        if (id == R.id.menu_element1) {
            AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
            alertDlg.setTitle("HELP");
            alertDlg.setMessage("ソフトウェア開発演習課題アプリ\n食事案内アプリver1.0");
            alertDlg.setPositiveButton("OK", null);
            alertDlg.create().show();
        }
        if (id == R.id.menu_element2) {
            AlertDialog.Builder alertDlg = new AlertDialog.Builder(this);
            alertDlg.setTitle("アプリを終了");
            alertDlg.setMessage("OKを押すとアプリを終了します。");
            alertDlg.setPositiveButton(
                    "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
            alertDlg.setNegativeButton(
                    "Cancel",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
            alertDlg.create().show();
        }
        return true;
    }
}
