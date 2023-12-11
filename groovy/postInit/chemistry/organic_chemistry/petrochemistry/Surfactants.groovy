import static globals.Globals.*

CSTR = recipemap('continuous_stirred_tank_reactor')
TBR = recipemap('trickle_bed_reactor')
FBR = recipemap('fixed_bed_reactor')
BCR = recipemap('bubble_column_reactor')
BR = recipemap('batch_reactor')
FLUIDIZEDBR = recipemap('fluidized_bed_reactor')
DISTILLATION_TOWER = recipemap('distillation_tower')
DISTILLERY = recipemap('distillery')
ROASTER = recipemap('roaster')
CRYSTALLIZER = recipemap('crystallizer')
MIXER = recipemap('mixer')
DRYER = recipemap('dryer')
CHEMICAL_BATH = recipemap('chemical_bath')
LCR = recipemap('large_chemical_reactor')

// Lubricity Surfactants (SDS, Narrow-chain ethoxylates)

CSTR.recipeBuilder()
    .notConsumable(ore('platePolytetrafluoroethylene') * 6)
    .fluidInputs(fluid('sulfur_trioxide') * 50)
    .fluidInputs(fluid('hydrogen_chloride') * 50)
    .fluidOutputs(fluid('chlorosulfuric_acid') * 50)
    .duration(5)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .notConsumable(ore('platePolytetrafluoroethylene') * 6)
    .fluidInputs(fluid('chlorosulfuric_acid') * 1000)
    .fluidInputs(fluid('n_dodecanol') * 1000)
    .outputs(metaitem('dustHydrogenDodecylSulfate'))
    .fluidOutputs(fluid('hydrogen_chloride') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('n_dodecanol') * 1000)
    .fluidInputs(fluid('oleum') * 11000)
    .outputs(metaitem('dustHydrogenDodecylSulfate'))
    .fluidOutputs(fluid('sulfuric_acid') * 10000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(metaitem('dustHydrogenDodecylSulfate'))
    .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('sodium_dodecyl_sulfate_solution') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()
    
DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sodium_dodecyl_sulfate_solution') * 1000)
    .fluidOutputs(fluid('sodium_dodecyl_sulfate') * 144)
    .fluidOutputs(fluid('water') * 2000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustTinySodiumHydroxide'))
    .fluidInputs(fluid('ethylene_oxide') * 1000)
    .fluidInputs(fluid('n_butanol') * 1000)
    .fluidOutputs(fluid('two_butoxyethanol') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

// Antistatic surfactant (dinonylnaphthalene sulfonate)

BR.recipeBuilder()
    .fluidInputs(fluid('napthalene') * 1000)
    .fluidInputs(fluid('tripropylene') * 2000)
    .notConsumable(fluid('hydrofluoric_acid') * 100)
    .outputs(metaitem('dustDinonylnaphthalene'))
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustDinonylnaphthalene'))
    .fluidInputs(fluid('oleum') * 11000)
    .outputs(metaitem('dustDinonylnaphthaleneSulfonicAcid'))
    .fluidOutputs(fluid('sulfuric_acid') * 10000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .notConsumable(ore('platePolytetrafluoroethylene') * 6)
    .inputs(ore('dustDinonylnaphthalene'))
    .fluidInputs(fluid('chlorosulfuric_acid') * 1000)
    .outputs(metaitem('dustDinonylnaphthaleneSulfonicAcid'))
    .fluidOutputs(fluid('hydrogen_chloride') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()