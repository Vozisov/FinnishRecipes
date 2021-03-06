package aaa.bbb.ccc07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Recipe> listRecipes = new ArrayList<>();

    String[] recNames;
    int[] mainImages = new int[]{R.drawable.mainimg1, R.drawable.mainimg2, R.drawable.mainimg3, R.drawable.mainimg4,
            R.drawable.mainimg5, R.drawable.mainimg6, R.drawable.mainimg7, R.drawable.mainimg8, R.drawable.mainimg9,
            R.drawable.mainimg10};

    int[][] allImgs = new int[][]{
            {R.drawable.img11, R.drawable.img12, R.drawable.img13, R.drawable.img14, R.drawable.img15
                    , R.drawable.img16, R.drawable.img17},

            {R.drawable.img21, R.drawable.img22, R.drawable.img23, R.drawable.img24, R.drawable.img25
                    , R.drawable.img26, R.drawable.img27},

            {R.drawable.img31, R.drawable.img32, R.drawable.img33, R.drawable.img34, R.drawable.img35
                    , R.drawable.img36, R.drawable.img37, R.drawable.img38},

            {R.drawable.img41, R.drawable.img42, R.drawable.img43, R.drawable.img44, R.drawable.img45
                    , R.drawable.img46, R.drawable.img47, R.drawable.img48, R.drawable.img49, R.drawable.img410},

            {R.drawable.img51, R.drawable.img52, R.drawable.img53, R.drawable.img54, R.drawable.img55
                    , R.drawable.img56, R.drawable.img57, R.drawable.img58, R.drawable.img59, R.drawable.img510, R.drawable.img511},

            {R.drawable.img61, R.drawable.img62, R.drawable.img63, R.drawable.img64, R.drawable.img65
                    , R.drawable.img66, R.drawable.img67, R.drawable.img68, R.drawable.img69},

            {R.drawable.img71, R.drawable.img72, R.drawable.img73, R.drawable.img74, R.drawable.img75
                    , R.drawable.img76, R.drawable.img77, R.drawable.img78, R.drawable.img79, R.drawable.img710},

            {R.drawable.img81, R.drawable.img82, R.drawable.img83, R.drawable.img84, R.drawable.img85
                    , R.drawable.img86, R.drawable.img87, R.drawable.img88},

            {R.drawable.img91, R.drawable.img92, R.drawable.img93, R.drawable.img94, R.drawable.img95
                    , R.drawable.img96, R.drawable.img97},

            {R.drawable.img101, R.drawable.img102, R.drawable.img103, R.drawable.img104, R.drawable.img105
                    , R.drawable.img106, R.drawable.img107, R.drawable.img108, R.drawable.img109}
    };
    int[][] fullTexts = new int[][]{
            {R.string.text11, R.string.text12, R.string.text13, R.string.text14, R.string.text15
                    , R.string.text16, R.string.text17},

            {R.string.text21, R.string.text22, R.string.text23, R.string.text24, R.string.text25
                    , R.string.text26, R.string.text27},

            {R.string.text31, R.string.text32, R.string.text33, R.string.text34, R.string.text35
                    , R.string.text36, R.string.text37, R.string.text38},

            {R.string.text41, R.string.text42, R.string.text43, R.string.text44, R.string.text45
                    , R.string.text46, R.string.text47, R.string.text48, R.string.text49, R.string.text410},

            {R.string.text51, R.string.text52, R.string.text53, R.string.text54, R.string.text55
                    , R.string.text56, R.string.text57, R.string.text58, R.string.text59, R.string.text510, R.string.text511},

            {R.string.text61, R.string.text62, R.string.text63, R.string.text64, R.string.text65
                    , R.string.text66, R.string.text67, R.string.text68, R.string.text69},

            {R.string.text71, R.string.text72, R.string.text73, R.string.text74, R.string.text75
                    , R.string.text76, R.string.text77, R.string.text78, R.string.text79, R.string.text710},

            {R.string.text81, R.string.text82, R.string.text83, R.string.text84, R.string.text85
                    , R.string.text86, R.string.text87, R.string.text88},

            {R.string.text91, R.string.text92, R.string.text93, R.string.text94, R.string.text95
                    , R.string.text96, R.string.text97},

            {R.string.text101, R.string.text102, R.string.text103, R.string.text104, R.string.text105
                    , R.string.text106, R.string.text107, R.string.text108, R.string.text109}
    };

    int[] ingr1 = new int[]{R.array.ingr1, R.array.ingr2, R.array.ingr3, R.array.ingr4, R.array.ingr5
            , R.array.ingr6, R.array.ingr7, R.array.ingr8, R.array.ingr9, R.array.ingr10};


    int[] caloryes = new int[]{120, 78, 90, 270, 42, 90, 291, 225, 258, 124};
    String[] times = new String[]{"1 ч. 20 мин.", "40 мин.", "8 ч.", "40 мин.", "1 ч. 40 мин.", "35 мин.", "2 ч.",
            "1 ч.", "30 мин.", "45 мин."};


    ListView recList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recNames = getResources().getStringArray(R.array.recNames);

        for (int i = 0; i < recNames.length; i++) {
            Recipe recipe = new Recipe(mainImages[i], allImgs[i], recNames[i], fullTexts[i],
                    ingr1[i], caloryes[i], times[i]);
            listRecipes.add(recipe);
        }

        recList = findViewById(R.id.recList);

        RecAdapter adapter = new RecAdapter(this, listRecipes);
        recList.setAdapter(adapter);

        recList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, RecDetail.class);
                intent.putExtra("pos", position);
                startActivity(intent);
            }
        });

    }
}
