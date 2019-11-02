# Minecraft Forge 1.12.2 BaseMod
 This is a Base Version of a basic Forge Mod (1.12.2)
 It was programmed using the latest IntelliJ IDEA version (you can just import it to IntelliJ by selecting the "build.gradlew"
 To be sure that everything is working properly, be sure to run the startDecompWorkspace task (locatable at the right side of IntelliJ, to start Minecraft, run the task startClient)
 
  The base Mod is well commented, so really easy to understand and it even features some ready made Copper and Tin Items as well as an own Creative Tab entry!
  
  
  ## Creating new Items / Blocks
  To create new Items and Blocks you just need to edit /init/ModItems.java or /init/ModBlocks.java
  
  For Items:
  ```java
// Items
public static final Item <ITEM_NAME> = new <Item Base>("item_name");
public static final Item INGOT_TIN = new ItemBase("ingot_tin");
// Tools
public static final <Minecraft ItemBase> <ITEM_NAME> = new <Item Base>("<item_name>", <ITEM_MATERIAL>);
public static final ItemSword COPPER_Sword = new CopperSword("copper_sword", MATERIAL_COPPER);
// Food
public static final Item FOOD_NAME = new FoodBase("food_name", 2, 3.5f, false);
// Food with effect
public static final Item FOOD_NAME = new FoodEffectBase("food_name", 2, 3.5f, false,
    new PotionEffect(MobEffects.HASTE, 60*20, 0, false, true));
  ```
For Blocks:
```java
public static final Block <BLOCK_NAME> = new <Block Base>("block_name", <Material>);

public static final Block ORE_TIN = new BlockBase("ore_tin", Material.IRON);
```
  If you want different Item / Block attributes (harvestLevel, resistance ...) create a new Base for this item inside the /items/ package (you can just copy the *Base.java and modify its attributes to match your needs)
  
  ## World Generation
  To add / modify the World Generation, just modify the /world/WorldGen.java class
  
  To add a new Ore to the World Generation, you need to create the Block first!
  
  Just modify the generateOverworld method to add new ores to your world (the example uses Ores that can be disabled! )
```java
if (ModConfigManager.oreCopper) {
    generateOre(ModBlocks.ORE_COPPER.getDefaultState(),
        world, random, chunkX * 16, chunkZ * 16, ModConfigManager.copperMinHeight, ModConfigManager.copperMaxHeight, random.nextInt(ModConfigManager.copperVeinSize) + 1, ModConfigManager.copperSpawnTries, BlockMatcher.forBlock(Blocks.STONE));
} else { }
```
If you want your Ores to generate in a different Dimension than the Overworld modify the generate function:
```java
// Overworld id = 0, Nether id = -1, The End id = 1
if (world.provider.getDimension() == 1) {
    generateEnd(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
}
```
Note that the function that is executed here is called generateEnd, in order to execute it, we need to create it first!
```java
private void generateEnd(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
    // Ores to generate here
}
```