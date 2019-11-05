# Minecraft Forge 1.12.2 BaseMod
 This is a Base Version of a basic Forge Mod (1.12.2)
 It was programmed using the latest IntelliJ IDEA version (you can just import it to IntelliJ by selecting the "build.gradlew"
 To be sure that everything is working properly, be sure to run the startDecompWorkspace task (locatable at the right side of IntelliJ, to start Minecraft, run the task startClient)
 
  The base Mod is well commented, so really easy to understand and it even features some ready made Copper and Tin Items as well as an own Creative Tab entry!
  
  
  ## Renaming your Mod 
  (Intellij may also work the same way for eclipse, but not tested)
  
  To rename your mod, right click the Project Root (Minecraft-Forge-1.12.2-BaseMod) and click "Replace in Path" and search for com.basemod.base and replace it with the name of your mod! (you may want to follow name conventions)
  then do the same step again, but just with "basemod" <- your mod ID, again change it to the mod ID your mod should have. 
  After you've done it, you also need to change the directory names. - You can do that directly inside of IntelliJ, just right click the folder /src/main/java/com.basemod.base and use "Refractor -> Rename..."
  ```
change those directory to what you set in the previous step! (com.basemod.base -> com/basemod/base)
/src/main/java/com/basemod
/src/main/java/com/basemod/base
change this directory to the mod ID you've set!
/resource/assets/testmod
```
Finally you may want to change some values inside "mcmod.info", "Resources.java" and build.gradle
  
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
  
  Note that you need to create the Textures for your new Items / Blocks and their .json
  
  .json files for blocks: 
  ```
/resources/assets/basemod/blockstates/block_name.json
/resources/assets/basemod/models/block/block_name.json
/resources/assets/basemod/models/item/block_name.json
```
.json files for Items:
```
/resources/assets/basemod/models/item/item_name.json
```
To name your Items / Blocks etc you need to edit the /resource/assets/basemod/lang/en_us.lang file.
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
To choose in which Blocks you want your ores to generate in, change the BlockMatcher.forBlock(BLOCK_TYPE) (in the example changed to Minecraft:Netherrack)
```java
private void generateNether(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
    generateOre(Blocks.REDSTONE_ORE.getDefaultState(),
        world, random, chunkX * 16, chunkZ * 16, 1, 255, random.nextInt(30) + 10, 24,BlockMatcher.forBlock(Blocks.NETHERRACK));
}
```
