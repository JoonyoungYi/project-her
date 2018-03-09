package kr.ac.kaist.eodi.api;

import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import kr.ac.kaist.eodi.model.Building;
import kr.ac.kaist.eodi.utils.PronounciationAlphbetManager;
import kr.ac.kaist.eodi.utils.PronounciationHanguelManager;
import kr.ac.kaist.eodi.utils.PronounciationNumberManager;

/**
 * Created by yearnning on 15. 4. 28..
 */
public class BuildingSearchApi {

    private static String TAG = "BuildingSearchApi";
    private ArrayList<Building> mBuildings;

    public BuildingSearchApi(ArrayList<String> keywords) {

        /**
         *
         */
        ArrayList<Building> mBuildings = new ArrayList<>();
        for (int i = 0; i < keywords.size(); i++) {
            Building building = getBuildingFromKeyword(keywords.get(i));
            if (building != null) {
                mBuildings.add(building);
            }

        }


        /**
         *  Merge
         */
        Collections.sort(mBuildings, new Comparator<Building>() {
            @Override
            public int compare(Building lhs, Building rhs) {
                return lhs.getName().compareTo(rhs.getName());
            }
        });

        if (mBuildings.size() > 0) {
            Building building_old = mBuildings.get(0);
            int i = 1;
            while (i < mBuildings.size()) {
                Building building = mBuildings.get(i);
                if (building.getSymbol().equals("?")) {
                    break;
                } else if (building.getSymbol().equals(building_old.getSymbol())) {
                    building_old.setKeyword(building_old.getKeyword() + ", " + building.getKeyword());
                    building_old.setMatch(building_old.getMatch() + building.getMatch());
                    mBuildings.remove(i);
                } else {
                    building_old = building;
                    i++;
                }
            }
        }

        /**
         * Sort
         */
        Collections.sort(mBuildings, new Comparator<Building>() {
            @Override
            public int compare(Building lhs, Building rhs) {
                return (lhs.getMatch() < rhs.getMatch() ? 1 : -1);
            }
        });

        /**
         *
         */
        this.mBuildings = mBuildings;

    }

    public ArrayList<Building> getResult() {
        return this.mBuildings;
    }

    private Building getBuildingFromKeyword(String keyword_original) {

        /**
         *
         */
        String keyword = keyword_original;

        /**
         * Exact Match
         */
        if (keyword.equals("에몬")) {
            keyword = "N1";
        } else if (keyword.equals("멜론")) {
            keyword = "N1";
        } else if (keyword.equals("은혼")) {
            keyword = "N1";
        } else if (keyword.equals("캐논")) {
            keyword = "N1";
        } else if (keyword.equals("wh")) {
            keyword = "W7";
        } else if (keyword.equals("w h")) {
            keyword = "W7";
        } else if (keyword.equals("위치")) {
            keyword = "E7";
        } else if (keyword.equals("it's")) {
            keyword = "E7";
        } else if (keyword.equals("web")) {
            keyword = "W12";
        } else if (keyword.equals("은영")) {
            keyword = "N0";
        } else if (keyword.equals("앤녕")) {
            keyword = "N0";
        } else if (keyword.equals("안뇽")) {
            keyword = "N0";
        } else if (keyword.equals("안 녕")) {
            keyword = "N0";
        } else if (keyword.equals("안녕")) {
            keyword = "N0";
        } else if (keyword.equals("ng 록")) {
            keyword = "N0";
        } else if (keyword.equals("예슬이")) {
            keyword = "N3";
        } else if (keyword.equals("mp3")) {
            keyword = "N3";
        } else if (keyword.equals("mp5")) {
            keyword = "N5";
        } else if (keyword.equals("md5")) {
            keyword = "N5";
        } else if (keyword.equals("에노")) {
            keyword = "N5";
        } else if (keyword.equals("미투")) {
            keyword = "E2";
        } else if (keyword.equals("익스")) {
            keyword = "E6";
        } else if (keyword.equals("이승은")) {
            keyword = "E7";
        } else if (keyword.equals("있으면")) {
            keyword = "E7";
        } else if (keyword.equals("있음은")) {
            keyword = "E7";
        } else if (keyword.equals("있으믄")) {
            keyword = "E7";
        } else if (keyword.equals("있으면은")) {
            keyword = "E7";
        } else if (keyword.equals("20일")) {
            keyword = "E11";
        } else if (keyword.equals("20")) {
            keyword = "E10";
        }

        /**
         * Before Removing space
         */
        keyword = keyword.replace("10 1", "11");
        keyword = keyword.replace("12일", "11");
        keyword = keyword.replace("10일", "11");

        try {
            if (keyword.length() >= 3 && keyword.substring(0, 3).equals("20 ")) {
                keyword = "E1" + keyword.substring(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            try {
                Integer.parseInt(keyword.substring(2, 3));
            } catch (Exception e) {
                int num = Integer.parseInt(keyword.substring(0, 2));
                if (num > 20 && num < 30) {
                    keyword = "E1" + (num % 10) + keyword.substring(2);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (keyword.substring(0, 3).equals("ie ")) {
                keyword = "E2" + keyword.substring(3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (keyword.substring(0, 2).equals("1 ")) {
                keyword = "E" + keyword.substring(2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         *
         */
        try {
            keyword = keyword.replace(" ", "");

            /**
             *
             */
            if (keyword.substring(0, 1).equals("2")) {
                keyword = keyword.replaceFirst("2", "E");
            } else if (keyword.substring(0, 1).equals("이")) {
                keyword = keyword.replaceFirst("이", "E");
            } else if (keyword.substring(0, 1).equals("히")) {
                keyword = keyword.replaceFirst("히", "E");
            } else if (keyword.substring(0, 1).equals("기")) {
                keyword = keyword.replaceFirst("기", "E");
            } else if (keyword.substring(0, 1).equals("비")) {
                keyword = keyword.replaceFirst("비", "E");
            } else if (keyword.substring(0, 1).equals("희")) {
                keyword = keyword.replaceFirst("희", "E");
            } else if (keyword.substring(0, 1).equals("티")) {
                keyword = keyword.replaceFirst("티", "E");
            } else if (keyword.substring(0, 1).equals("지")) {
                keyword = keyword.replaceFirst("지", "E");
            } else if (keyword.substring(0, 1).equals("g")) {
                keyword = keyword.replaceFirst("g", "E");
            } else if (keyword.substring(0, 1).equals("엔")) {
                keyword = keyword.replaceFirst("엔", "N");
            } else if (keyword.substring(0, 2).equals("애니")) {
                keyword = keyword.replaceFirst("애니", "N");
            } else if (keyword.substring(0, 1).equals("앤")) {
                keyword = keyword.replaceFirst("앤", "N");
            } else if (keyword.substring(0, 1).equals("인")) {
                keyword = keyword.replaceFirst("인", "N");
            } else if (keyword.substring(0, 1).equals("m")) {
                keyword = keyword.replaceFirst("m", "N");
            } else if (keyword.substring(0, 2).equals("빨리")) {
                keyword = keyword.replaceFirst("빨리", "W");
            } else if (keyword.substring(0, 1).equals("안")) {
                keyword = keyword.replaceFirst("안", "N");
            } else if (keyword.substring(0, 2).equals("in")) {
                keyword = keyword.replaceFirst("in", "N");
            } else if (keyword.substring(0, 2).equals("an")) {
                keyword = keyword.replaceFirst("an", "N");
            } else if (keyword.substring(0, 1).equals("언")) {
                keyword = keyword.replaceFirst("언", "N");
            } else if (keyword.substring(0, 1).equals("엠")) {
                keyword = keyword.replaceFirst("엠", "N");
            } else if (keyword.substring(0, 1).equals("왠")) {
                keyword = keyword.replaceFirst("왠", "N");
            } else if (keyword.substring(0, 1).equals("만")) {
                keyword = keyword.replaceFirst("만", "N");
            } else if (keyword.substring(0, 1).equals("신")) {
                keyword = keyword.replaceFirst("신", "N");
            } else if (keyword.substring(0, 1).equals("텐")) {
                keyword = keyword.replaceFirst("텐", "N");
            } else if (keyword.substring(0, 2).equals("en")) {
                keyword = keyword.replaceFirst("en", "N");
            } else if (keyword.substring(0, 1).equals("미")) {
                keyword = keyword.replaceFirst("미", "E");
            }

            /**
             * Part + Number Exact
             */
            if (keyword.equals("N드라이브")) {
                keyword = "N5";
            } else if (keyword.equals("n드라이브")) {
                keyword = "N5";
            }

            /**
             * Number Exact
             */
            keyword = keyword.replace("식스", "6");
            keyword = keyword.replace("CX", "6");
            keyword = keyword.replace("섹스", "6");
            keyword = keyword.replace("sex", "6");

            /**
             *
             */
            keyword = keyword.replace("J옥", "0");
            keyword = keyword.replace("젤이옥", "0");
            keyword = keyword.replace("젤옥", "0");
            keyword = keyword.replace("젤록", "0");
            keyword = keyword.replace("제록", "0");
            keyword = keyword.replace("Z옥", "0");
            keyword = keyword.replace("영", "0");
            keyword = keyword.replace("녕", "0");
            keyword = keyword.replace("뇽", "0");
            keyword = keyword.replace("다시", "-");
            keyword = keyword.replace(" 4시 ", "-");
            keyword = keyword.replace("원", "1");
            keyword = keyword.replace("on", "1");
            keyword = keyword.replace("an", "1");
            keyword = keyword.replace("투", "2");
            keyword = keyword.replace("토", "2");
            keyword = keyword.replace("쓰리", "3");
            keyword = keyword.replace("슬이", "3");
            keyword = keyword.replace("쁘", "4");
            keyword = keyword.replace("뽀", "4");
            keyword = keyword.replace("포", "4");
            keyword = keyword.replace("파이브", "5");
            keyword = keyword.replace("five", "5");
            keyword = keyword.replace("파니", "5");
            keyword = keyword.replace("식섹스", "6");
            keyword = keyword.replace("제로", "0");
            keyword = keyword.replace("A", "8");
            keyword = keyword.replace("AT", "8");
            keyword = keyword.replace("나인", "9");
            keyword = keyword.replace("태", "10");
            keyword = keyword.replace("튼", "10");
            keyword = keyword.replace("o", "5");
            keyword = keyword.replace("u", "6");
            keyword = keyword.replace("십일", "11");
            keyword = keyword.replace("일", "1");
            keyword = keyword.replace("십오", "15");
            keyword = keyword.replace("십", "10");
            keyword = keyword.replace("일레븐", "11");
            keyword = keyword.replace("름은", "11");
            keyword = keyword.replace("지은", "11");
            keyword = keyword.replace("은", "11");
            keyword = keyword.replace("ellen", "11");
            keyword = keyword.replace("eleven", "11");
            keyword = keyword.replace("이", "2");
            keyword = keyword.replace("ie", "E2");
            keyword = keyword.substring(0, 1) + keyword.substring(1).replace("e", "2");
            keyword = keyword.replace("트", "2");
            keyword = keyword.replace("특", "2");
            keyword = keyword.replace("삼", "3");
            keyword = keyword.replace("사", "4");
            keyword = keyword.replace("호", "5");
            keyword = keyword.replace("우", "5");
            keyword = keyword.replace("육", "6");
            keyword = keyword.replace("륙", "6");
            keyword = keyword.replace("체", "7");
            keyword = keyword.replace("치", "7");
            keyword = keyword.replace("구", "9");
            keyword = keyword.replace("싶", "10");
            keyword = keyword.replace("씹", "10");
            keyword = keyword.replace("cb", "12");
            keyword = keyword.replace("오", "5");
            keyword = keyword.replace("로", "5");
            keyword = keyword.replace("홍", "5");
            keyword = keyword.replace("용", "5");
            keyword = keyword.replace("몽", "5");
            keyword = keyword.replace("모", "5");

            /**
             *
             */
            keyword = keyword.toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         *
         */
        Building building = Building.newInstance(keyword);
        if (building == null) {
            return getBuildingFromKeywordGeneral(keyword_original);
        } else {
            building.setMatch(1);
        }
        building.setKeyword(keyword_original);

        return building;
    }


    private Building getBuildingFromKeywordGeneral(String keyword_original) {

        Building building_max = null;
        int s_max = -1;

        /**
         *
         */
        ArrayList<String> keywords = getKeywordPronounciations(keyword_original);
        for (String keyword : keywords) {


            /**
             *
             */
            ArrayList<Building> mAllBuildings = Building.allInstances();
            for (Building building : mAllBuildings) {

                String[] pronouns = building.getPronouns();
                if (pronouns != null) {
                    for (String pronoun : pronouns) {
                        if (pronoun.length() >= keyword.length()) {

                            /**
                             *
                             */
                            int s = 0;
                            for (int i = 0; i < keyword.length(); i++) {

                                /**
                                 *
                                 */
                                int c1 = keyword.charAt(i) - 0xAC00;
                                if (c1 < 0) {
                                    continue;
                                }
                                int c2 = pronoun.charAt(i) - 0xAC00;
                                if (c2 < 0) {
                                    continue;
                                }

                                /**
                                 *
                                 */
                                int c1_cho = (c1 / 28) / 21;
                                int c1_jung = (c1 / 28) % 21;
                                int c1_jong = c1 % 28;

                                Log.d(TAG, "c1   -> " + keyword.charAt(i));
                                Log.d(TAG, "cho  -> " + c1_cho);
                                Log.d(TAG, "jung -> " + c1_jung);
                                Log.d(TAG, "jong -> " + c1_jong);

                                /**
                                 *
                                 */
                                int c2_cho = (c2 / 28) / 21;
                                int c2_jung = (c2 / 28) % 21;
                                int c2_jong = c2 % 28;

                                Log.d(TAG, "c2   -> " + pronoun.charAt(i));
                                Log.d(TAG, "cho  -> " + c2_cho);
                                Log.d(TAG, "jung -> " + c2_jung);
                                Log.d(TAG, "jong -> " + c2_jong);

                                /**
                                 *
                                 */
                                int s_cho = PronounciationHanguelManager.similarityCho(c1_cho, c2_cho);
                                int s_jung = PronounciationHanguelManager.similarityJung(c1_jung, c2_jung);
                                int s_jong = PronounciationHanguelManager.similarityJong(c1_jong, c2_jong);
                                s += (s_cho + s_jung + s_jong);
                            }

                            s = s / keyword.length();

                            /**
                             *
                             */
                            if (s > 0 && s > s_max) {
                                building_max = building;
                                s_max = s;
                            }
                        }

                    }
                }
            }

        }

        /**
         *
         */
        if (building_max != null) {
            building_max.setKeyword(keyword_original);
            building_max.setMatch((float) ((float) s_max / ((float) 100)));
            return building_max;
        } else {
            Building building = new Building();
            building.setLocation(building.newLocationInstance(0, 0));
            building.setSymbol("?");
            building.setName(keyword_original);
            building.setMatch(0);
            building.setKeyword(keyword_original);
            return building;
        }
    }


    private ArrayList<String> getKeywordPronounciations(String keyword_original) {

        /**
         *
         */
        ArrayList<String> keywords = new ArrayList<>();
        keywords.add("");

        /**
         *
         */
        String[] keyword_splited = keyword_original.split(" ");
        for (String word_splited : keyword_splited) {

            /**
             *
             */
            String[] pronouns = null;
            if (PronounciationNumberManager.isInteger(word_splited)) {
                pronouns = PronounciationNumberManager.getPronounciationOfInteger(Integer.parseInt(word_splited));
            } else {
                String word = "";
                for (int i = 0; i < word_splited.length(); i++) {
                    char w = word_splited.charAt(i);
                    String alphabet = PronounciationAlphbetManager.getPronounciationOfAlphabet(w);
                    if (alphabet != null) {
                        word += alphabet;
                        continue;
                    }
                    String num = PronounciationNumberManager.getPronounciationOfIntegerChar(w);
                    if (num != null) {
                        word += num;
                        continue;
                    }
                    word += w;
                }

                pronouns = new String[]{word};
            }

            /**
             *
             */
            ArrayList<String> keywords_temp = new ArrayList<>();
            for (String p : pronouns) {
                for (int i = 0; i < keywords.size(); i++) {
                    String w = keywords.get(i) + p;
                    keywords_temp.add(w);
                }
            }
            keywords.clear();
            keywords.addAll(keywords_temp);
        }


        return keywords;
    }


}
