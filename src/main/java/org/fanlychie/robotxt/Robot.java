package org.fanlychie.robotxt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by fanlychie on 2018/3/27.
 */
public final class Robot {

    private static final int SEED_SIZE = 100;

    private static final double[] SEED_PROB = {0.5, 0.18, 0.12, 0.08, 0.07, 0.05};

    private static final String LAST_NAME = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟丘徐邱骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经房裘缪干解应宗丁宣贲邓单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄曲家封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘景詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逢逄姬申扶堵冉宰郦雍?S璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东欧殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查荆红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于单于太叔申屠公孙仲孙轩辕令狐钟离宇文长孙慕容鲜于闾丘司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福";

    private static final String FIRST_NAME_MALE = "耀怀堂堃理将标选吉尉逊谊栋谋同名民树向耕耘瀚通尚琛瀛君思营琥谦琦尧琨栩启琰谱琳水谷永逸根总格琼耿汀汉行衍灏桐桑恒桔联硕展聚瑛瑜瑞江衡桢健桥遥桦豪聪鑫豫山灵葵屹豹顺恺瑾灿梁颂领璇颉钊璋和炎咏岑梓岗蒙沙岚沛炜增璞璟钟颢沣邦钦钧墨岩墩炬岭炯岱育傲鲲河炳治炼郁烁铁品烈泉蓉磊泊棋风铎泓蓓裕铖胜蓝飞棠波胤峥烨士蓬铭壮森铮峰泰声哲泳银铸峻泽烽攀洁锁崇崊锋洋植崎锐儒椒焕焘蔚甜贝生锟财贤津锦崧锨天洪甫锬键唯焰田焱洲甲申锴崴贵洵然男贺礼放政元畅兆奇镇先光煊克煌奎济畏奔奕祖敖嵘赛煜赞楠赢祥略煦照全浩嵩浪赫敬嵬镭兴兵其海楷典啸腾西冀善禄超喆疆文冉越斌涌福斐榕冕熙军涛农喜冠熠润馨冬斯新冲涵冶禹熹方禾燃跃旋野科旗川州淞凡臣旦淦巩旭淮凯路闯深至淳致时旺臻添旻闻淼函闽言昀威昂清帅帆昆万嘉昊渊上昌希明与成易阔世列战刚业创丛东舜渝丞星舟戟队映鸣渤春严利航中昭港舰丰昱稳阳昶舸游丹为举显鸿陆义之晋才虎鹏晏乐剑晓晔晖晗湘湛晟习鹤牧晨普良景驰鹰平鉴晴年陵陶幸特艺智登乾广承骁庄骅庆隆犇誉骋骏序源云麒皓溓亚庚力骞功麟红溢骥亦亨纪溪京纬庭亮励劲纲蚵纶康劼隽仁雁勃雄勇盈勉益立勋绍雍拓滔苗高默曙盛竞盟章满勤若以曦继雨滨雪园端英仲维直延廷雷相竹固建任盼曼国盾开霁茂异霄霆圆震月有朋鼎笑朔化霖朗北众弘会猛笛望弛朝霞伟真传欢弢圣伦弦欧献振伯地露朴强挺魁千权歆升潇均卉杉歌华子材齐青卓策南存坚博佚潜孝非孟卡罡坡荣正季坤彤来学武彦坦杨轩革佩彪卫彬轮潮杰印影轲佳轶佶捷松卿睿宁征侃玄垄澄宇辉安律融玎宏辑林宗龙宙厚定垚辛宜果澜宝实原侠宣垣群宪枫议玮微辰讳家德宸玺宽羽达宾羿翀迁珂心毅寅迅密珉俊珊翊友富双翌珍城迎柏运发寒翔志诗诚进远保连忠信韦韧珩韩迪韬语俭可柯翰柱忱菲石韵念韶培珺诺基翼";

    private static final String FIRST_NAME_FEMALE = "萃理谊萌同萍名小研尔琚君琛氛思吟怡尤营琦逦谦尧簧谨琨倩栩琪含琬琰萱琳琴逸琸永琼格怿汀桂桃聆汇汉恋偌灏屏桐桑恒桔联硕瑕瑗瑛瑜汝瑞江葡桢遥桥桦恩聪豫恬灵葵瑶瑷屹顺瑾灿沁颂梅颇璇颉钊颍炎咏璐颐频岑梓颖蒙沙岚沛炜颜璜璞璟颢钥梦悦钦碧钧岩沫岭炯钰育炼粼郁烁品铃情蓉泉棋飒蓓泓裕飘裙蓝惟惠郡波胤峥郦烨铭森铮峰哲泳银峻泽攀洁愉洋锋意锐椒蔓焕蔚甜贝贞素贤津锦天洪唯田焱申洵然蔷洺贺礼允元畅奇慈光蕊克奎敏赏奕嵘蕙楚煜楠祥煦慧浩赫敬祯兰女兴蕴啸祺蕾西如妃喆薇文冉妍斐醒涓榕香妙熙涛熠妤馥馨冬妮斯冰新妲涵冶妹禹熹方喻禾秀净跃采淇秋旋淋巍旎淑燕旖姗旗凝姝川州凡姣凤巧闪姬旭路淳臻旻闻添淼函姿言昀昂娅清娆帆娇嘉娉渊希明舒娓昕丛娜渝娟舟映娣鸣娥春鸥利昭丰爱樱昱渲阳娴常丹爽丽鸿繁鹂鹃婉义晋晏乐晓乔晔婕晖晗湘书婧牧晨鹭良晰艳晴婵晶婷幸虹艺智白艾骁骄芄骅予誉骊芊皎骏云皓暖亚媚媛芝红溢纨溪芬纬亭芮纯芯花励芳纶芷芸芹劼雁雅苇盈益立苑嫒苒苓滔苗默仙嫚绚黛囡滢嫣勤令若雨雪仪园绮雯英嫱维延竹苹任曼盼霁霄圆月眉茉伊霏笑朔霖茗缘笛茜霜蜜霞真伟欢欣伦朦欧缨漪漫霭振露茵朵伶茹千荃歆潇均卉杉华杏齐青靓荔单策靖南静博坚筝潞非荟筠荣正季彤坤学彩轩佩卫彬杭影筱佳蝴蝶荷捷睻卿睿宁侃玄澄宇玉莉安辉融美莎玎箐羚辛澜宜果枝宝依玟玢宣群玥枫玫议玮微环辰玲莲讳殷莹容玹莺羽徽达翀菁珂心毅迅密忆珉菊珊俊翊双翌珍迎翎珏菏俏俐珑寒诒毓柔翔诗诚远连俞珠翠忠菡信珣知韦韧珩迪俪矫韫韬语珮可柯台翰菱忱菲音韵念叶韶珺诺忻";

    private static final String[] TEL_PREFIX = "139,138,137,136,135,134,188,187,184,183,182,178,159,158,157,152,151,150,186,185,176,156,155,132,131,130,175,176,166,189,181,180,177,153,133,173".split(",");

    private static final String EMAIL_PREFIX = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz_0123456789";

    private static final String[] EMAIL_SUFFIX = "@gmail.com,@qq.com,@163.com,@yeah.net,@126.com,@sina.com,@sohu.com,@hotmail.com,@yahoo.com".split(",");

    private static final int SEED_INIT_SIZE = 1000;

    private static final Set<String> UNIQUE_SET = new HashSet<>();

    private static final LinkedList<String> TEL_LIST = new LinkedList<>();

    private static final LinkedList<String> EMAIL_LIST = new LinkedList<>();



    public static void main(String[] args) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 2000; i++) {
            System.out.println(format.format(getDate()));
        }
    }

    private static Date getDate() {
        Calendar calendar = Calendar.getInstance();
        Random random = ThreadLocalRandom.current();
        calendar.add(Calendar.DAY_OF_MONTH, random.nextInt(13870) * -1);
        calendar.add(Calendar.HOUR_OF_DAY, random.nextInt(12));
        calendar.add(Calendar.MINUTE, random.nextInt(30));
        calendar.add(Calendar.SECOND, random.nextInt(30));
        return calendar.getTime();
    }

    public static String getEmail(String prefix) {
        return prefix + EMAIL_SUFFIX[ThreadLocalRandom.current().nextInt(EMAIL_SUFFIX.length)];
    }

    public static String getTel() {
        if (TEL_LIST.size() == 0) {
            synchronized (TEL_LIST) {
                if (TEL_LIST.size() == 0) {
                    initTel();
                }
            }
        }
        return TEL_LIST.remove();
    }

    public static String getEmail() {
        if (EMAIL_LIST.size() == 0) {
            synchronized (EMAIL_LIST) {
                if (EMAIL_LIST.size() == 0) {
                    initEmail();
                }
            }
        }
        return getEmail(EMAIL_LIST.remove());
    }

    public static String getName() {
        return getName(ThreadLocalRandom.current().nextBoolean());
    }

    public static String getMaleName() {
        return getName(false);
    }

    public static String getFemaleName() {
        return getName(true);
    }

    public static String getName(boolean isFemale) {
        Random random = ThreadLocalRandom.current();
        return getRandomLastName(random) + getRandomFirstName(random, isFemale);
    }

    public static String getSex() {
        return ThreadLocalRandom.current().nextBoolean() ? "男" : "女";
    }

    // 初始化手机号码
    private static void initTel() {
        synchronized (TEL_LIST) {
            String tel;
            Random random = ThreadLocalRandom.current();
            while (TEL_LIST.size() < SEED_INIT_SIZE) {
                do {
                    int seed = random.nextInt(89999999) + 10000000;
                    tel = TEL_PREFIX[random.nextInt(TEL_PREFIX.length)] + seed;
                } while (UNIQUE_SET.contains(tel));
                TEL_LIST.add(tel);
                UNIQUE_SET.add(tel);
            }
        }
    }

    // 初始化邮箱
    private static void initEmail() {
        synchronized (EMAIL_LIST) {
            String email;
            Random random = ThreadLocalRandom.current();
            while (EMAIL_LIST.size() < SEED_INIT_SIZE) {
                do {
                    StringBuilder emailBuilder = new StringBuilder();
                    int length = random.nextInt(9) + 8;
                    for (int i = 0; i < length; i++) {
                        char ch = EMAIL_PREFIX.charAt(random.nextInt(EMAIL_PREFIX.length()));
                        while (i == 0 && (ch >= '0' && ch <= '9' || ch >= 'a' && ch <= 'z' || ch == '_')) {
                            ch = EMAIL_PREFIX.charAt(random.nextInt(EMAIL_PREFIX.length()));
                        }
                        emailBuilder.append(ch);
                    }
                    email = emailBuilder.toString();
                } while (UNIQUE_SET.contains(email));
                EMAIL_LIST.add(email);
                UNIQUE_SET.add(email);
            }
        }
    }

    // 按概率生成姓
    private static char getRandomLastName(Random random) {
        double seed = Math.random();
        if (SEED_PROB[0] >= seed) {
            return LAST_NAME.charAt(random.nextInt(SEED_SIZE));
        } else if (SEED_PROB[0] + SEED_PROB[1] >= seed) {
            return LAST_NAME.charAt(random.nextInt(SEED_SIZE) + SEED_SIZE);
        } else if (SEED_PROB[0] + SEED_PROB[1] + SEED_PROB[2] >= seed) {
            return LAST_NAME.charAt(random.nextInt(SEED_SIZE) + SEED_SIZE * 2);
        } else if (SEED_PROB[0] + SEED_PROB[1] + SEED_PROB[2] + SEED_PROB[3] >= seed) {
            return LAST_NAME.charAt(random.nextInt(SEED_SIZE) + SEED_SIZE * 3);
        } else if (SEED_PROB[0] + SEED_PROB[1] + SEED_PROB[2] + SEED_PROB[3] + SEED_PROB[4] >= seed) {
            return LAST_NAME.charAt(random.nextInt(SEED_SIZE) + SEED_SIZE * 4);
        } else {
            return LAST_NAME.charAt(random.nextInt(LAST_NAME.length() - SEED_SIZE * 5) + SEED_SIZE * 5);
        }
    }

    // 随机生成名字
    private static String getRandomFirstName(Random random, boolean isFemale) {
        StringBuilder name = new StringBuilder();
        if (isFemale) {
            name.append(getRandomFemaleFirstNameChar(random)).append(getRandomFemaleFirstNameChar(random));
        } else {
            name.append(getRandomMaleFirstNameChar(random)).append(getRandomMaleFirstNameChar(random));
        }
        return name.toString();
    }

    // 随机的男性名字
    private static char getRandomMaleFirstNameChar(Random random) {
        return FIRST_NAME_MALE.charAt(random.nextInt(FIRST_NAME_MALE.length()));
    }

    // 随机的女性名字
    private static char getRandomFemaleFirstNameChar(Random random) {
        return FIRST_NAME_FEMALE.charAt(random.nextInt(FIRST_NAME_FEMALE.length()));
    }

}