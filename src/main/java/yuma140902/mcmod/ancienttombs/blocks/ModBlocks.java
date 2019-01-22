package yuma140902.mcmod.ancienttombs.blocks;

public final class ModBlocks {
	private ModBlocks() {}
	
	public static void register() {
		mosesDummyBlock.register();
	}
	
	public static BlockMosesDummy mosesDummyBlock = new BlockMosesDummy();
}
