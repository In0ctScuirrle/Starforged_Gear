package lu.embellishedduck.starforgedgear.datagen;

import lu.embellishedduck.starforgedgear.StarforgedGear;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

/*
Embellished Duck
@author Will Blanchard
 */
public class ModEnLangProvider extends LanguageProvider {

    //Constructor
    public ModEnLangProvider(PackOutput output) {
        super(output, StarforgedGear.MOD_ID, "en_us");
    }//End of Constructor

    //Simply just put addItem(ModItems.CONDYLE, "Condyle")
    @Override
    protected void addTranslations() {

    }//End of Method
}//End of Class
