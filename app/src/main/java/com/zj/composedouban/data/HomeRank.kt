package com.zj.composedouban.data

data class HomeTopRank(
    val title: String,
    val imgUrl: String,
    val startColor: Long,
    val endColor: Long,
    val list: List<TopRankMovie>,
)

data class TopRankMovie(
    val title: String,
    val score: String
)

data class HomeTypeRankItem(
    val title: String,
    val subTitle: String,
    val imgUrl: String,
    val startColor: Long,
    val endColor: Long,
    val topOne: String,
    val topTwo: String,
    val topThree: String
)

val homeTopRankList = listOf(
    HomeTopRank(
        "豆瓣电影 Top250",
        "https://img2.doubanio.com/view/photo/s_ratio_poster/public/p480747492.jpg",
        0xFF7F6351,
        0x807F6351,
        listOf(
            TopRankMovie("1 肖申克的救赎", "9.7分"),
            TopRankMovie("2 霸王别姬", "9.6分"),
            TopRankMovie("3 阿甘正传", "9.5分")
        )
    ),
    HomeTopRank(
        "一周口碑电影榜",
        "https://img1.doubanio.com/view/photo/l/public/p2629054917.webp",
        0xFF403542,
        0x80403542,
        listOf(
            TopRankMovie("1 新.福音战士剧场版:终", "9.2分"),
            TopRankMovie("2 再见了所有福音战士", "9.2分"),
            TopRankMovie("3 健听女孩", "8.6分")
        )
    ),
    HomeTopRank(
        "实时热门电影",
        "https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2673412189.webp",
        0xFF2C2C33,
        0x802C2C33,
        listOf(
            TopRankMovie("1 小姐", "8.3分"),
            TopRankMovie("2 夏日友晴天", "7.3分"),
            TopRankMovie("3 怒火·重案", "7.5分")
        )
    )
)

val homeTypeRankList = listOf(
    HomeTypeRankItem(
        "高分电影Top20",
        "近期",
        "https://img9.doubanio.com/view/photo/l/public/p2631551315.webp",
        0xFF002942,
        0x80002942,
        "1 你好，李焕英",
        "2 心灵奇旅",
        "3 正义联盟"
    ),
    HomeTypeRankItem(
        "喜剧片",
        "高分经典",
        "https://img3.doubanio.com/view/photo/l/public/p579724050.webp",
        0xFF52363A,
        0x8052363A,
        "1 三傻大闹宝莱坞",
        "2 大话西游之月光宝盒",
        "3 两杆大烟枪"
    ),
    HomeTypeRankItem(
        "动作片",
        "高分经典",
        "https://img1.doubanio.com/view/photo/l/public/p1353751178.webp",
        0xFF2D3E52,
        0x802D3E52,
        "1 蝙蝠侠：黑暗骑士崛起",
        "2 谍影重重3",
        "3 复仇者联盟4：终局之战"
    ),
    HomeTypeRankItem(
        "爱情片",
        "高分经典",
        "https://img1.doubanio.com/view/photo/l/public/p2605864037.webp",
        0xFF673535,
        0x80673535,
        "1 泰坦尼克号",
        "2 大话西游之大圣娶亲",
        "3 乱世佳人"
    ),
    HomeTypeRankItem(
        "科幻片",
        "高分经典",
        "https://img9.doubanio.com/view/photo/l/public/p2208063344.webp",
        0xFF424957,
        0x80424957,
        "1 星际穿越",
        "2 黑客帝国",
        "3 头号玩家"
    ),
    HomeTypeRankItem(
        "动画片",
        "高分经典",
        "https://img9.doubanio.com/view/photo/l/public/p2512319014.webp",
        0xFF493E53,
        0x80493E53,
        "1 千与千寻",
        "2 机器人总动员",
        "3 疯狂动物城"
    ),
    HomeTypeRankItem(
        "悬疑片",
        "高分经典",
        "https://img1.doubanio.com/view/photo/l/public/p616901547.webp",
        0xFF443839,
        0x80443839,
        "1 盗梦空间",
        "2 无间道",
        "3 搏击俱乐部"
    ),
    HomeTypeRankItem(
        "音乐片",
        "高分经典",
        "https://img2.doubanio.com/view/photo/l/public/p2572401442.webp",
        0xFF002942,
        0x80002942,
        "1 海上钢琴师",
        "2 放牛班的春天",
        "3 钢琴家"
    ),
    HomeTypeRankItem(
        "历史片",
        "高分经典",
        "https://img1.doubanio.com/view/photo/l/public/p2214090809.webp",
        0xFF7F6351,
        0x807F6351,
        "1 辛德勒的名单",
        "2 活着",
        "3 乱世佳人"
    ),
    HomeTypeRankItem(
        "战争片",
        "高分经典",
        "https://img1.doubanio.com/view/photo/l/public/p2533776779.webp",
        0xFF403542,
        0x80403542,
        "1 美丽人生",
        "2 辛德勒的名单",
        "3 乱世佳人"
    )
)