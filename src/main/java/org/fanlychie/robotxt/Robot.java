package org.fanlychie.robotxt;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by fanlychie on 2018/3/27.
 */
public final class Robot {

    private static final int SEED_SIZE = 100;

    private static final double[] PER_SEED = {0.5, 0.18, 0.12, 0.08, 0.07, 0.05};

    private static final String LAST_NAME = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟丘徐邱骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经房裘缪干解应宗丁宣贲邓单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄曲家封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘景詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逢逄姬申扶堵冉宰郦雍?S璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东欧殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查荆红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于单于太叔申屠公孙仲孙轩辕令狐钟离宇文长孙慕容鲜于闾丘司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福";

    private static final String FIRST_NAME_FOR_MALE = "耀怀堂堃标选逊栋树耕耘瀚通瀛栩逸根总格耿行衍灏桐桑恒桔联硕聚衡桢健桥遥桦聪灵顺恺灿颂领颉炎梓炜增颢邦墨墩炬炯育傲炳炼郁烁烈磊棋风裕胜飞棠胤烨士森壮声烽植儒椒焕焘天焰焱然礼元兆奇先光煊克煌奎奔奕祖煜楠祥煦照全兴兵其楷典腾西冀禄冉福榕冕熙军农冠熠馨冬冲冶禹熹禾燃野科凡臣凯至臻函言威成列战刚创舜舟戟利航舰稳舸剑牧良驰鉴特艺承骁骅犇誉骋骏力骞功骥励劲劼勃勇勉立勋拓苗高竞章勤端英竹茂笑化北猛笛欢欧献振挺魁千歆升卉歌华子卓策南存博孝孟卡荣正季学武卫印捷卿玄宇安玎宏宗宙定宜宝实原宣宪议玮讳家宸玺宽宾珂毅寅密珉珊友双富珍寒诗诚珩语可菲珺诺理将吉尉谊谋同名民向尚君琛营琥谦琦尧琨启琰谱琳水谷永琼汀汉展瑛瑜瑞江豪鑫豫山葵屹豹瑾璇钊璋和咏岑岗蒙沙岚沛璞璟钟沣钦钧岩岭岱鲲河治铁品泉蓉泊铎泓蓓铖蓝波峥蓬铭铮峰泰哲泳银铸峻泽攀洁锁崇崊锋洋崎锐蔚甜贝生锟财贤津锦崧锨洪甫锬键唯田洲甲申锴崴贵洵男贺放政畅镇济畏敖嵘赛赞赢略浩嵩浪赫敬嵬镭海啸超喆疆文越斌涌斐涛喜润斯新涵方跃旋旗川州淞旦淦巩旭淮路闯深淳时旺添旻闻淼闽昀昂清帅帆昆万嘉昊渊上昌希明与易阔世业丛东渝丞星队映鸣渤春严昭中港丰昱阳昶游丹为举显鸿陆义之晋虎鹏晏乐晓晔晖晗湘湛晟习鹤晨普景鹰平晴年陵陶幸智登乾广庄庆隆序源云麒皓溓亚庚麟红溢亦纪溪京纬庭亮纲蚵纶康隽仁雁雄盈益绍雍滔默曙盛盟满曦继雨滨雪园仲维直延廷雷相建任盼曼国盾开霁异霄霆圆震月有朋鼎朔霖朗众弘望弛朝霞伟真传弢圣伦弦地露朴强权潇均杉材齐青佚坚潜非罡坡坤彤来彦坦杨轩革佩彪彬潮杰影轲佳轶佶松睿征侃垄澄辉律融辑龙垚辛果澜侠垣群枫微辰德羽达羿翀迁心迅俊翊翌城迎柏运翔志进远保连忠信韦韧韩迪韬俭柯翰柱忱石柳韵念韶培基翼";

    private static final String FIRST_NAME_FOR_FEMALE = "研瀚砚思怡逦倩栩逸格怿桂桃聆恋偌灏桐桑恒桔联硕桢遥桥桦恩恬灵顺灿颂梅颇颉颍炎颐频梓颖炜颜颢悦梦碧墩炯育炼郁烁情棋飒裕裙惟惠郡胤郦烨森愉意椒焕天焱然礼允元奇慈光克奎奕楚煜楠祥煦慧祯兰女兴祺西如妃冉妍醒榕香妙熙熠妤馨冬妮冰妲冶妹禹熹禾秀净采秋燕姗凝姝凡姣凤姬臻函姿言娅娆娇娉舒娓娜娟舟娣娥利樱爱娴爽婉婕婧牧良艳婵婷艺艾骁骄芄骅誉骊芊骏媚媛芝芬芮芯花励芳芷芸芹劼苇立苑嫒苒苓苗嫚嫣若英嫱苹竹茉笑北茗笛茜欢欣欧振茵茹千荃歆卉华单策南博筝荟筠正季学卫筱捷荷卿宁玄宇莉玉安莎玎箐宜宝玟玢宣玥玫议玮环玲莲讳殷莹容玹莺菁珂毅密珉珊菊双珍珏菏珑诒寒毓诗诚珠菡珣珩语珮可台菱菲叶珺诺萃理吉尉谊萌同萍名小民尔尚琚君琛氛吟尤营琦谦尧簧谨琨琪含琰萱琳琴琸永琼汀汇汉屏展瑕瑗瑛瑜汝瑞江葡豪豫葵瑶瑷屹瑾沁璇钊咏璐岑蒙沙岚沛璜璞璟钥钦钧岩咪沫岭钰粼品铃蓉泉泓蓓蓝波峥铭铮峰哲泳银峻泽攀洁洋锋锐蔓蔚甜贝贞素贤津锦洪唯田申洵蔷洺贺放政畅蕊敏赏嵘蕙浩赫敬蕴啸蕾喆文薇斐涓涛斯新涵方喻跃淇旋淋巍旎淑旖旗川州巧闪旭路淳旻闻添淼昀昂清帆嘉渊希明昕丛渝映鸣春鸥丰昱渲阳常丹丽鸿繁鹂鹃义晋晏乐晓乔晔晖晗湘书晨鹭晰晴晶幸虹智白予皎云皓暖亚红溢溪纬亭纯纶雁雅盈益滔默仙绚囡滢令雨雪仪园绮雯维延任曼盼霁霄圆月眉伊霏朔霖弘缘霜蜜霞真伟伦朦缨漪漫露朵伶潇均杉杏齐青靓靖静坚潞非彤坤彩轩佩彬杭影佳蝴蝶睻睿侃澄辉融美羚辛澜果依群枫微辰羽徽达翀心迅忆俊翊翌迎翎俏俐翔远连俞翠忠信知韦韧迪俪矫韫韬柯翰忱音韵念韶忻";

    private static final int LAST_NAME_LENGTH = LAST_NAME.length();

    private static final int FIRST_NAME_FOR_MALE_LENGTH = FIRST_NAME_FOR_MALE.length();

    private static final int FIRST_NAME_FOR_FEMALE_LENGTH = FIRST_NAME_FOR_FEMALE.length();

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            System.out.println(getName());
        }
    }

    public static String getSex() {
        return ThreadLocalRandom.current().nextBoolean() ? "男" : "女";
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

    // 按概率生成姓
    private static char getRandomLastName(Random random) {
        double seed = Math.random();
        if (PER_SEED[0] >= seed) {
            return LAST_NAME.charAt(random.nextInt(SEED_SIZE));
        } else if (PER_SEED[0] + PER_SEED[1] >= seed) {
            return LAST_NAME.charAt(random.nextInt(SEED_SIZE) + SEED_SIZE);
        } else if (PER_SEED[0] + PER_SEED[1] + PER_SEED[2] >= seed) {
            return LAST_NAME.charAt(random.nextInt(SEED_SIZE) + SEED_SIZE * 2);
        } else if (PER_SEED[0] + PER_SEED[1] + PER_SEED[2] + PER_SEED[3] >= seed) {
            return LAST_NAME.charAt(random.nextInt(SEED_SIZE) + SEED_SIZE * 3);
        } else if (PER_SEED[0] + PER_SEED[1] + PER_SEED[2] + PER_SEED[3] + PER_SEED[4] >= seed) {
            return LAST_NAME.charAt(random.nextInt(SEED_SIZE) + SEED_SIZE * 4);
        } else {
            return LAST_NAME.charAt(random.nextInt(LAST_NAME_LENGTH - SEED_SIZE * 5) + SEED_SIZE * 5);
        }
    }

    // 随机生成名字
    private static String getRandomFirstName(Random random, boolean isFemale) {
        StringBuilder name = new StringBuilder();
        if (isFemale) {
            name.append(FIRST_NAME_FOR_FEMALE.charAt(random.nextInt(FIRST_NAME_FOR_FEMALE_LENGTH)))
                    .append(FIRST_NAME_FOR_FEMALE.charAt(random.nextInt(FIRST_NAME_FOR_FEMALE_LENGTH)));
        } else {
            name.append(FIRST_NAME_FOR_MALE.charAt(random.nextInt(FIRST_NAME_FOR_MALE_LENGTH)))
                    .append(FIRST_NAME_FOR_MALE.charAt(random.nextInt(FIRST_NAME_FOR_MALE_LENGTH)));
        }
        return name.toString();
    }

}