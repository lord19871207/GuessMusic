package com.zhi.app.data;

/**
 * 歌曲数据类
 * @author zhidf
 *
 */
public class Constant {
	public static final int INDEX_FILE_NAME = 0;

	/** 歌曲索引 */
	public static final int INDEX_SONG_NAME = 1;
	
	/** 可用的金币 */
	public static final int AVAILABLE_COIN = 1000;

	public static final String[][] SONG_INFO = { 
		{ "__00000.m4a", "征服" }, 
		{ "__00001.m4a", "童话" },
		{ "__00002.m4a", "同桌的你" }, 
		{ "__00003.m4a", "七里香" }, 
		{ "__00004.m4a", "传奇" },
		{ "__00005.m4a", "大海" }, 
		{ "__00006.m4a", "后来" }, 
		{ "__00007.m4a", "你的背包" },
		{ "__00008.m4a", "再见" }, 
		{ "__00009.m4a", "老男孩" }, 
		{ "__00010.m4a", "龙的传人" },
	};
	
	public static final String SAVE_FILE_NAME = "data.dat";
	public static final int INDEX_CURR_STAGE = 0;
	public static final int INDEX_COIN_NUM = 1;
}
