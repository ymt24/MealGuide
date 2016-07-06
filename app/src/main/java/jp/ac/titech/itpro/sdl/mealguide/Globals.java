package jp.ac.titech.itpro.sdl.mealguide;

import android.app.Application;

import java.util.ArrayList;

/**
 * グローバル変数を格納するクラス
 */
public class Globals extends Application {
    public class restaurant{
        private String name;    //店名
        private double[] place = new double[2];   //座標
        private int imageId;    //画像のID
        String time;    //営業時間
        String url; //URL
        public restaurant(double x, double y, String name, int id, String t, String url){
            this.place[0] = x;
            this.place[1] = y;
            this.name = name;
            this.imageId = id;
            this.time = t;
            this.url = url;
        }
        //店の座標を取得
        public double[] getPlace(){
            return place;
        }
        //店名を取得
        public String getName(){
            return name;
        }
        //画像IDの取得
        public int getImageId(){
            return imageId;
        }
        //営業時間の取得
        public String getTime(){
            return time;
        }
        //urlの取得
        public String getUrl(){
            return url;
        }
    }

    String nowUrl = "https://www.google.co.jp/"; //推薦中のレストランのurl

    ArrayList<restaurant> China = new ArrayList<restaurant>();
    ArrayList<restaurant> Ramen = new ArrayList<restaurant>();
    ArrayList<restaurant> Curry = new ArrayList<restaurant>();
    ArrayList<restaurant> Set = new ArrayList<restaurant>();
    ArrayList<restaurant> Italy = new ArrayList<restaurant>();
    ArrayList<restaurant> Any = new ArrayList<restaurant>();
    ArrayList<restaurant> Fashion = new ArrayList<restaurant>();

    ArrayList<restaurant> All = new ArrayList<restaurant>();    //候補リスト

    public void AllInit(){  //全レストランの初期化
        //中華
        China.add(new restaurant(35.606927, 139.685357, "四川屋台", R.drawable.shisen, "11:30～14:50, 17:00～23:30", "http://tabelog.com/tokyo/A1317/A131711/13003297/dtlrvwlst/"));
        China.add(new restaurant(35.606468,139.685938, "上海台所味庵", R.drawable.ajian, "11:30～15:00, 17:00～23:00", "http://tabelog.com/tokyo/A1317/A131711/13033373/dtlrvwlst/"));
        //ラーメン
        Ramen.add(new restaurant(35.603832, 139.684897, "麺屋こころ", R.drawable.kokoro, "11:30～15:00, 18:00～22:00", "http://www.menya-cocoro.com/"));
        Ramen.add(new restaurant(35.605981, 139.686192, "麺・飯場たんや", R.drawable.tanya, "11:30～14:00, 17:30～21:00", "http://tann-ya.com/"));
        Ramen.add(new restaurant(35.606068, 139.686191, "麺でる真紅", R.drawable.shinku, "11:30～14:30, 17:00～22:00", "http://tabelog.com/tokyo/A1317/A131711/13177514/dtlrvwlst/"));
        Ramen.add(new restaurant(35.606566, 139.685370, "らーめん凌駕", R.drawable.ryoga, "11:00～23:00", "http://tabelog.com/tokyo/A1317/A131711/13048427/dtlrvwlst/"));
        Ramen.add(new restaurant(35.608822, 139.685543, "餃子の王将", R.drawable.osho, "9:00～23:00", "https://www.ohsho.co.jp/menu/east.html"));
        Ramen.add(new restaurant(35.610479, 139.684696, "しま坂", R.drawable.shimasaka, "11:30～14:00, 18:00～23:00", "http://www.shimazaka.com/menu/"));
        Ramen.add(new restaurant(35.607193, 139.686130, "歌志軒", R.drawable.kajiken, "11:00～15:00, 18:00～24:00", "http://www.kajiken.biz/%E3%81%8A%E5%93%81%E6%9B%B8%E3%81%8D/"));
        Ramen.add(new restaurant(35.608538, 139.685533, "ひるがお", R.drawable.hirugao, "11:30～15:30, 17:30～22:00", "http://www.setaga-ya.com/shop/hirugao_ohokayama.html"));
        //カレー
        Curry.add(new restaurant(35.607193, 139.686130, "シッダールタ", R.drawable.shidaruta, "11:00～15:00, 17:00～23:00", "http://tabelog.com/tokyo/A1317/A131711/13045152/dtlrvwlst/"));
        Curry.add(new restaurant(35.611059, 139.684561, "コピラ", R.drawable.kopira, "11:00～15:00, 17:00～23:00", "http://tabelog.com/tokyo/A1317/A131711/13053358/dtlrvwlst/"));
        Curry.add(new restaurant(35.609153, 139.685645, "CoCo壱番屋", R.drawable.kokoichi, "11:00～22:00", "http://www.ichibanya.co.jp/menu/index.html"));
        //定食
        Set.add(new restaurant(35.606584, 139.685806, "だいにんぐらく", R.drawable.raku, "11:30～13:45, 17:00～24:00", "http://www.ookayamaraku.com/menu.php?category=919"));
        Set.add(new restaurant(35.605077, 139.686104, "やぶそば", R.drawable.yabu, "11:00～23:00", "http://tabelog.com/tokyo/A1317/A131711/13048041/dtlrvwlst/"));
        Set.add(new restaurant(35.608048, 139.684721, "九絵", R.drawable.kue, "11:30～14:00, 18:00～23:30", "http://tabelog.com/tokyo/A1317/A131711/13040797/dtlrvwlst/"));
        //イタリアン
        Italy.add(new restaurant(35.607117, 139.686320, "サイゼリヤ", R.drawable.saize, "11:00～24:00", "http://www.saizeriya.co.jp/menu/grandmenu.html"));
        //なんでもいい
        Any.add(new restaurant(35.609093, 139.685625, "松屋", R.drawable.matuya, "24時間営業", "http://www.matsuyafoods.co.jp/menu/"));
        Any.add(new restaurant(35.606998, 139.685358, "マクドナルド", R.drawable.mac, "24時間営業", "http://www.mcdonalds.co.jp/menu/burger/index.html"));
        Any.add(new restaurant(35.604570, 139.683137, "東工大生協第二食堂", R.drawable.nishoku, "11:00～20:00", "http://www.univcoop.jp/titech/news_3/cate_list.php?a=cate_list&news_cate_id=10"));
        //お洒落
        Fashion.add(new restaurant(35.607725, 139.668675, "自由が丘", R.drawable.free, "店によりけり", "http://tabelog.com/tokyo/A1317/A131703/rstLst/RC/"));
    }
}
