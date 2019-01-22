package yuma140902.mcmod.ancienttombs.items;

public final class ModItems {
	private ModItems() {}
	
	public static void register() {
		goldenSeal.register();
		mosesTenCommandments.register();
	}
	
	public static ItemGoldenSeal goldenSeal = new ItemGoldenSeal();
	public static ItemMosesTenCommandments mosesTenCommandments = new ItemMosesTenCommandments();
}
