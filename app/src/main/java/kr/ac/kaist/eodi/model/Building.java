package kr.ac.kaist.eodi.model;

import android.location.Location;

import java.util.ArrayList;

import kr.ac.kaist.eodi.R;

/**
 * Created by yearnning on 15. 4. 28..
 */
public class Building {

    /***
     *
     */
    private String name;
    private Location location;
    private String symbol;
    private String keyword;
    private int image_resource = 0;
    private float match = 0;
    private String[] pronouns;

    /**
     *
     */
    public static Building newInstance(String symbol) {

        /**
         *
         */
        String symbol_part;
        int symbol_number;
        try {
            symbol_part = symbol.substring(0, 1);
            symbol_number = Integer.parseInt(symbol.replace("-", "").substring(1));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        /**
         *
         */
        Building building = new Building();
        building.setSymbol(symbol);
        building.setLocation(Building.newLocationInstance(36.369392, 127.364025));

        /**
         *
         */
        if (symbol_part.equals("E")) {

            switch (symbol_number) {
                case 1:
                    building.setName("정문(Main Gate)");
                    building.setPronouns(new String[]{"이원", "이일"});
                    building.setImage_resource(R.drawable.building_e1);
                    break;
                case 2:
                    building.setName("산업경영학동(Industrial Engineering & Management B/D)");
                    building.setImage_resource(R.drawable.building_e2);
                    building.setPronouns(new String[]{"이투", "이이"});
                    break;
                case 3:
                    building.setName("정보전자공학동(Information & Electronics B/D)");
                    building.setImage_resource(R.drawable.building_e3);
                    building.setPronouns(new String[]{"이쓰리", "이삼"});
                    break;
                case 4:
                    building.setName("KI빌딩(KAIST Institutes B/D)");
                    building.setImage_resource(R.drawable.building_e4);
                    building.setPronouns(new String[]{"이포", "이사"});
                    break;
                case 5:
                    building.setName("교직원회관(Faculty Hall)");
                    building.setImage_resource(R.drawable.building_e5);
                    building.setPronouns(new String[]{"이파이브", "이오"});
                    break;
                case 6:
                    building.setName("자연과학동(Natural Science B/D)");
                    building.setImage_resource(R.drawable.building_e6);
                    building.setPronouns(new String[]{"이식스", "이육"});
                    break;
                case 7:
                    building.setName("의과학연구센터(Biomedical Research Center)");
                    building.setPronouns(new String[]{"이세븐", "이칠"});
                    break;
                case 8:
                    building.setName("세종관(Sejong Hall)");
                    building.setPronouns(new String[]{"이에잇", "이팔"});
                    break;
                case 9:
                    building.setName("중앙도서관(Main Library)");
                    building.setImage_resource(R.drawable.building_e9);
                    building.setPronouns(new String[]{"이나인", "이구"});
                    break;
                case 10:
                    building.setName("중앙창고(Storehouse)");
                    building.setPronouns(new String[]{"이텐", "이십"});
                    break;
                case 11:
                    building.setName("창의학습관(Creative Learning B/D)");
                    building.setImage_resource(R.drawable.building_e11);
                    building.setPronouns(new String[]{"이일레븐", "이십일"});
                    break;
                case 12:
                    building.setName("중앙기계실(Energy Plant)");
                    building.setPronouns(new String[]{"이트웰브", "이십이"});
                    break;
                case 13:
                    building.setName("인공위성연구센터(Satellite Technology Research Center)");
                    building.setImage_resource(R.drawable.building_e13);
                    building.setPronouns(new String[]{"이떨틴", "이십삼"});
                    break;
                case 14:
                    building.setName("본관(Main Administration B/D)");
                    building.setImage_resource(R.drawable.building_e14);
                    building.setPronouns(new String[]{"이포틴", "이십사"});
                    break;
                case 15:
                    building.setName("대강당(Auditorium)");
                    building.setImage_resource(R.drawable.building_e15);
                    building.setPronouns(new String[]{"이피프틴", "이십오"});
                    break;
                case 16:
                    building.setName("정문술빌딩(ChungMoonSoul B/D)");
                    building.setImage_resource(R.drawable.building_e16);
                    building.setPronouns(new String[]{"이식스틴", "이십육"});
                    break;
                case 17:
                    building.setName("운동장(Stadium)");
                    building.setImage_resource(R.drawable.building_e17);
                    building.setPronouns(new String[]{"이세븐틴", "이십칠"});
                    break;
                case 181:
                    building.setName("바이오모델 시스템파크(Bio Model System Park)");
                    building.setPronouns(new String[]{"이에이틴", "이십팔", "이십팔다시일"});
                    break;
                case 182:
                    building.setName("대전질환모델동물센터(Daejeon Disease-model animal Center)");
                    building.setPronouns(new String[]{"이에이틴", "이십팔", "이십팔다시이"});
                    break;
                case 19:
                    building.setName("나노팹센터(National Nano Fab Center)");
                    building.setPronouns(new String[]{"이십구", "이나인틴"});
                    break;
                case 20:
                    building.setName("계룡관(Kyeryong Hall)");
                    building.setPronouns(new String[]{"이이십", "이트웬티"});
                    break;
                case 21:
                    building.setName("메티컬센터(Medical Center)");
                    building.setImage_resource(R.drawable.building_e21);
                    building.setPronouns(new String[]{"이이십일"});
                    break;
                default:
                    return null;
            }

        } else if (symbol_part.equals("W")) {

            switch (symbol_number) {
                case 1:
                    building.setName("응용공학동(Applied Engineering B/D)");
                    building.setImage_resource(R.drawable.building_w1);
                    building.setPronouns(new String[]{"더블유원", "더블유일"});
                    break;
                case 2:
                    building.setName("학생회관-1(Student Center-1)");
                    building.setImage_resource(R.drawable.building_w2);
                    building.setPronouns(new String[]{"더블유투", "더블유이"});
                    break;
                case 3:
                    building.setName("갈릴레이관(Galilei Hall)");
                    building.setPronouns(new String[]{"더블유쓰리", "더블유삼"});
                    break;
                case 41:
                    building.setName("여울관(Yeoul Hall)");
                    building.setPronouns(new String[]{"더블유사", "더블유포", "더블유사다시일", "더블유포다시원", "더블유포다시일"});
                    break;
                case 42:
                    building.setName("나들관(Nadl Hall)");
                    building.setPronouns(new String[]{"더블유사", "더블유포", "더블유사다시이", "더블유포다시투", "더블유포다시이"});
                    break;
                case 43:
                    building.setName("다솜관(Dasom Hall)");
                    building.setPronouns(new String[]{"더블유사", "더블유포", "더블유사다시삼", "더블유포다시쓰리", "더블유포다시삼"});
                    break;
                case 44:
                    building.setName("희망관(Heemang Hall)");
                    building.setPronouns(new String[]{"더블유사", "더블유포", "더블유사다시사", "더블유포다시포", "더블유포다시사"});
                    break;
                case 5:
                    building.setName("기혼자기숙사·인터내셔널빌리지(Married Students Housing & International Village)");
                    building.setPronouns(new String[]{"더블유오", "더블유파이브"});
                    break;
                case 6:
                    building.setName("미르관·나래관(Mir Hall & Narae Hall)");
                    building.setPronouns(new String[]{"더블유육", "더블유식스"});
                    break;
                case 7:
                    building.setName("나눔관(Nanum Hall)");
                    building.setPronouns(new String[]{"더블유세븐", "더블유칠"});
                    break;
                case 8:
                    building.setName("교육지원동(Educational Support B/D)");
                    building.setImage_resource(R.drawable.building_w8);
                    building.setPronouns(new String[]{"더블유팔", "더블유에잇"});
                    break;
                case 9:
                    building.setName("노천극장(Outdoor Theater)");
                    building.setImage_resource(R.drawable.building_w9);
                    building.setPronouns(new String[]{"더블유구", "더블유나인"});
                    break;
                case 10:
                    building.setName("풍동실험실(Wind Tunnel Laboratory)");
                    building.setPronouns(new String[]{"더블유십", "더블유텐"});
                    break;
                case 11:
                    building.setName("외국인교수 아파트(International Faculty Apartment)");
                    building.setImage_resource(R.drawable.building_w11);
                    building.setPronouns(new String[]{"더블유십일", "더블유일레븐"});
                    break;
                case 12:
                    building.setName("서측기계실(West Energy Plant)");
                    building.setPronouns(new String[]{"더블유십이", "더블유트웰브"});
                    break;
                case 16:
                    building.setName("지오센트리퓨지 실험동(Geotechnical Centrifuge Testing Center)");
                    building.setImage_resource(R.drawable.building_w16);
                    building.setPronouns(new String[]{"더블유십육", "더블유식스틴"});
                    break;
                default:
                    return null;
            }

        } else if (symbol_part.equals("N")) {

            switch (symbol_number) {
                case 0:
                    building.setName("동문(East Gate)");
                    building.setPronouns(new String[]{"엔제로", "엔영"});
                    break;
                case 1:
                    building.setName("김병호·김삼열 IT융합 빌딩(Kim Beang-Ho & Kim Sam-Youl ITC Building)");
                    building.setImage_resource(R.drawable.building_n1);
                    building.setPronouns(new String[]{"엔일", "엔원"});
                    break;
                case 2:
                    building.setName("행정분관(Branch Administration B/D)");
                    building.setImage_resource(R.drawable.building_n2);
                    building.setPronouns(new String[]{"엔투", "엔이"});
                    break;
                case 3:
                    building.setName("스포츠 컴플렉스(Sports Complex)");
                    building.setImage_resource(R.drawable.building_n3);
                    building.setPronouns(new String[]{"엔삼", "엔쓰리"});
                    break;
                case 4:
                    building.setName("인문사회과학부동(School of Humanities & Social Science B/D)");
                    building.setImage_resource(R.drawable.building_n4);
                    building.setPronouns(new String[]{"엔사", "엔포"});
                    break;
                case 5:
                    building.setName("기초실험연구동(Basic Experiment & Research B/D)");
                    building.setPronouns(new String[]{"엔오", "엔파이브"});
                    break;
                case 6:
                    building.setName("교수회관(Faculty Club)");
                    building.setPronouns(new String[]{"엔육", "엔식스"});
                    break;
                case 7:
                    building.setName("기계공학동(Mechanical Engineering B/D)");
                    building.setImage_resource(R.drawable.building_n7);
                    building.setPronouns(new String[]{"엔칠", "엔세븐"});
                    break;
                case 9:
                    building.setName("실습동(Practice B/D)");
                    building.setPronouns(new String[]{"엔구", "엔나인"});
                    break;
                case 10:
                    building.setName("교양분관(Undergraduate Branch Library)");
                    building.setImage_resource(R.drawable.building_n10);
                    building.setPronouns(new String[]{"엔십", "엔텐"});
                    break;
                case 11:
                    building.setName("학생식당(Cafeteria)");
                    building.setPronouns(new String[]{"엔십일", "엔일레븐"});
                    break;
                case 12:
                    building.setName("학생회관-2(Student Center-2)");
                    building.setPronouns(new String[]{"엔십이", "엔투엘브"});
                    break;
                case 13:
                    building.setName("태울관(Tae Wul Gwan)");
                    building.setPronouns(new String[]{"엔십삼", "엔떨틴"});
                    break;
                case 131:
                    building.setName("장영신 학생회관(Chang Young shin Student Activity Center)");
                    building.setPronouns(new String[]{"엔십삼", "엔떨틴", "엔떨틴다시일", "엔십삼다시일"});
                    break;
                case 14:
                    building.setName("사랑관(Sarang Hall)");
                    building.setPronouns(new String[]{"엔십사", "엔포틴"});
                    break;
                case 15:
                    building.setName("교직원 숙소(Staff accommodation)");
                    building.setPronouns(new String[]{"엔십오", "엔피프틴"});
                    break;
                case 16:
                    building.setName("소망관(Somang Hall)");
                    building.setPronouns(new String[]{"엔십육", "엔식스틴"});
                    break;
                case 17:
                    building.setName("성실관(Seongsil Hall)");
                    building.setPronouns(new String[]{"엔세븐틴", "엔십칠"});
                    break;
                case 18:
                    building.setName("진리관(Jilli Hall)");
                    building.setPronouns(new String[]{"엔십팔", "엔에이틴"});
                    break;
                case 19:
                    building.setName("아름관(Areum Hall)");
                    building.setPronouns(new String[]{"엔십구", "엔나인틴"});
                    break;
                case 20:
                    building.setName("신뢰관(Silloe Hall)");
                    building.setPronouns(new String[]{"엔이십", "엔트웬티"});
                    break;
                case 21:
                    building.setName("지혜관(Jihye Hall)");
                    building.setPronouns(new String[]{"엔이십일", "엔트웬티원"});
                    break;
                case 22:
                    building.setName("동문창업관(Alumni Venture Hall)");
                    building.setImage_resource(R.drawable.building_n22);
                    building.setPronouns(new String[]{"엔이십이", "엔트웬티투"});
                    break;
                case 23:
                    building.setName("fMRI센터(fMRI Center)");
                    building.setImage_resource(R.drawable.building_n23);
                    building.setPronouns(new String[]{"엔이십삼", "엔트웬티쓰리"});
                    break;
                case 24:
                    building.setName("LG세미콘홀(LG Semicon Hall)");
                    building.setImage_resource(R.drawable.building_n24);
                    building.setPronouns(new String[]{"엔이십사", "엔트웬티포"});
                    break;
                case 25:
                    building.setName("산업디자인학과동(Dept. of Industrial Design B/D)");
                    building.setImage_resource(R.drawable.building_n25);
                    building.setPronouns(new String[]{"엔이십오", "엔트웬티파이브"});
                    break;
                case 26:
                    building.setName("고성능집적시스템연구센터(Center for High-Performance Integrated Systems)");
                    building.setImage_resource(R.drawable.building_n26);
                    building.setPronouns(new String[]{"엔이십육", "엔트웬티식스"});
                    break;
                case 27:
                    building.setName("유레카관(Eureka Hall)");
                    building.setImage_resource(R.drawable.building_n27);
                    building.setPronouns(new String[]{"엔이십칠", "엔트웬티세븐"});
                    break;
                case 28:
                    building.setName("에너지환경연구센터(Energy & Environment Research Center)");
                    building.setPronouns(new String[]{"엔이십팔", "엔트웬티에잇"});
                    break;
                default:
                    return null;
            }

        } else {
            return null;
        }

        return building;
    }

    public static Location newLocationInstance(double latitude, double longitude) {

        if (latitude != 0 && longitude != 0) {
            Location location = new Location("");
            location.setLatitude(latitude);
            location.setLongitude(longitude);
            return location;
        }

        return null;
    }

    public static ArrayList<Building> allInstances() {

        String[] dirs = {"E", "W", "N"};
        ArrayList<Building> buildings = new ArrayList<>();
        for (String dir : dirs) {
            for (int i = 0; i < 183; i++) {
                Building building = newInstance(dir + Integer.toString(i));
                if (building != null) {
                    buildings.add(building);
                }
            }
        }

        return buildings;
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public float getMatch() {
        return match;
    }

    public void setMatch(float match) {
        this.match = match;
    }

    public int getImage_resource() {
        return image_resource;
    }

    public void setImage_resource(int image_resource) {
        this.image_resource = image_resource;
    }

    public String[] getPronouns() {
        return pronouns;
    }

    public void setPronouns(String[] pronouns) {
        this.pronouns = pronouns;
    }


}
