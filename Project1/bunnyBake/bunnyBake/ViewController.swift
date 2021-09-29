//
//  ViewController.swift
//  bunnyBake
//
//  Created by Kevina Wong on 9/28/21.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var neuralBunny: UIImageView!
    
    // Selection Booleans
    
    var eggSelect:Bool = false;
    var milkSelect:Bool = false;
    var oilSelect:Bool = false;
    var butterSelect:Bool = false;
    var flourSelect:Bool = false;
    var whippingCreamSelect:Bool = false;
    var sugarSelect:Bool = false;
    var honeySelect:Bool = false;
    var molassesSelect:Bool = false;
    var appleSelect:Bool = false;
    var chocolateSelect:Bool = false;
    var cinnamonSelect:Bool = false;
    var vanillaSelect:Bool = false;
    var lemonSelect:Bool = false;
    var coffeeSelect:Bool = false;
    var mintSelect:Bool = false;
    var strawberrySelect:Bool = false;
    var bananaSelect:Bool = false;
    
    var flavor:String = "";

    // Button Outlets
    
    @IBOutlet weak var sugarOutlet: UIButton!
    @IBOutlet weak var honeyOutlet: UIButton!
    @IBOutlet weak var molassesOutlet: UIButton!
    @IBOutlet weak var cinnamonOutlet: UIButton!
    @IBOutlet weak var chocolateOutlet: UIButton!
    @IBOutlet weak var appleOutlet: UIButton!
    @IBOutlet weak var vanillaOutlet: UIButton!
    @IBOutlet weak var coffeeOutlet: UIButton!
    @IBOutlet weak var lemonOutlet: UIButton!
    @IBOutlet weak var bananaOutlet: UIButton!
    @IBOutlet weak var strawberryOutlet: UIButton!
    @IBOutlet weak var mintOutlet: UIButton!
    
    
    // Toggle Off Functions
    
    func sugarToggleOff(){
        sugarSelect = false;
        sugarOutlet.setImage(UIImage(named: "sugar"), for: UIControl.State.normal)
    }

    func honeyToggleOff(){
        honeySelect = false;
        honeyOutlet.setImage(UIImage(named: "hooney"), for: UIControl.State.normal)
    }

    func molassesToggleOff(){
        molassesSelect = false;
        molassesOutlet.setImage(UIImage(named: "molasses"), for: UIControl.State.normal)
    }
    
    func appleToggleOff(){
        appleSelect = false;
        appleOutlet.setImage(UIImage(named: "apple"), for: UIControl.State.normal)
        flavor = ""
    }
    
    func chocolateToggleOff(){
        chocolateSelect = false;
        chocolateOutlet.setImage(UIImage(named: "chocolate"), for: UIControl.State.normal)
        flavor = ""
    }
    func cinnamonToggleOff(){
        cinnamonSelect = false;
        cinnamonOutlet.setImage(UIImage(named: "cinnamon"), for: UIControl.State.normal)
        flavor = ""
    }
    
    func vanillaToggleOff(){
        vanillaSelect = false;
        vanillaOutlet.setImage(UIImage(named: "vanilla"), for: UIControl.State.normal)
        flavor = ""
    }
    
    func lemonToggleOff(){
        lemonSelect = false;
        lemonOutlet.setImage(UIImage(named: "lemon"), for: UIControl.State.normal)
        flavor = ""
    }
    
    func coffeeToggleOff(){
        coffeeSelect = false;
        coffeeOutlet.setImage(UIImage(named: "coffee"), for: UIControl.State.normal)
        flavor = ""
    }
    
    func mintToggleOff(){
        mintSelect = false;
        mintOutlet.setImage(UIImage(named: "mint"), for: UIControl.State.normal)
        flavor = ""
    }
    
    func strawberryToggleOff(){
        strawberrySelect = false;
        strawberryOutlet.setImage(UIImage(named: "strawberry"), for: UIControl.State.normal)
        flavor = ""
    }
    
    func bananaToggleOff(){
        bananaSelect = false;
        bananaOutlet.setImage(UIImage(named: "banana"), for: UIControl.State.normal)
        flavor = ""
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        neuralBunny.loadGif(name:"neutral_bunny")
    }
    
    // Select Main Ingredients
    
    @IBAction func eggSelection(_ sender: UIButton) {
        if eggSelect == false{
            eggSelect = true
            sender.setImage(UIImage(named:"eggs_selected"), for: UIControl.State.normal)
        }
        else if eggSelect == true{
            eggSelect = false;
            sender.setImage(UIImage(named: "eggs"), for: UIControl.State.normal)
        }
    }
    
    @IBAction func milkSelection(_ sender: UIButton) {
        
        if milkSelect == false{
            milkSelect = true
            sender.setImage(UIImage(named:"milk_selected"), for: UIControl.State.normal)
        }
        else if milkSelect == true{
            milkSelect = false;
            sender.setImage(UIImage(named: "milk"), for: UIControl.State.normal)
        }
    }
    
    
    @IBAction func oilSelection(_ sender: UIButton) {
        
        if oilSelect == false{
            oilSelect = true
            sender.setImage(UIImage(named:"oil_selected"), for: UIControl.State.normal)
        }
        else if oilSelect == true{
            oilSelect = false;
            sender.setImage(UIImage(named: "oil"), for: UIControl.State.normal)
        }
    }
    
    
    @IBAction func butterSelection(_ sender: UIButton) {
        if butterSelect == false{
            butterSelect = true
            sender.setImage(UIImage(named:"butter_selected"), for: UIControl.State.normal)
        }
        else if butterSelect == true{
            butterSelect = false;
            sender.setImage(UIImage(named: "butter"), for: UIControl.State.normal)
        }
    }
    
    @IBAction func flourSelection(_ sender: UIButton) {
        
        if flourSelect == false{
            flourSelect = true
            sender.setImage(UIImage(named:"flour_selected"), for: UIControl.State.normal)
        }
        else if flourSelect == true{
            flourSelect = false;
            sender.setImage(UIImage(named: "flour"), for: UIControl.State.normal)
        }
    }
    
    @IBAction func whippingCreamSelection(_ sender: UIButton) {
        
        if whippingCreamSelect == false{
            whippingCreamSelect = true
            sender.setImage(UIImage(named:"whipping_cream_selected"), for: UIControl.State.normal)
        }
        else if whippingCreamSelect == true{
            whippingCreamSelect = false;
            sender.setImage(UIImage(named: "whipping_cream"), for: UIControl.State.normal)
        }
    }
    
    // Select Sweetener
    
    @IBAction func sugarSelection(_ sender: UIButton) {
        
        honeyToggleOff()
        molassesToggleOff()
        
        if sugarSelect == false{
            sugarSelect = true
            sender.setImage(UIImage(named:"sugar_selected"), for: UIControl.State.normal)
        }
        else if sugarSelect == true{
            sugarSelect = false;
            sender.setImage(UIImage(named: "sugar"), for: UIControl.State.normal)
        }
    }
    
    @IBAction func honeySelection(_ sender: UIButton) {
        
        sugarToggleOff()
        molassesToggleOff()
        
        if honeySelect == false{
            honeySelect = true
            sender.setImage(UIImage(named:"hooney_selected"), for: UIControl.State.normal)
        }
        else if honeySelect == true{
            honeySelect = false;
            sender.setImage(UIImage(named: "hooney"), for: UIControl.State.normal)
        }
    }
    
    @IBAction func molassesSelection(_ sender: UIButton) {
        
        sugarToggleOff()
        honeyToggleOff()
        
        if molassesSelect == false{
            molassesSelect = true
            sender.setImage(UIImage(named:"molasses_selected"), for: UIControl.State.normal)
        }
        else if molassesSelect == true{
            molassesSelect = false;
            sender.setImage(UIImage(named: "molasses"), for: UIControl.State.normal)
        }
    }
    
    // Select Flavor
    
    @IBAction func appleSelection(_ sender: UIButton) {
        
        chocolateToggleOff()
        cinnamonToggleOff()
        vanillaToggleOff()
        lemonToggleOff()
        coffeeToggleOff()
        mintToggleOff()
        strawberryToggleOff()
        bananaToggleOff()
        
        
        if appleSelect == false{
            appleSelect = true
            sender.setImage(UIImage(named:"apple_selected"), for: UIControl.State.normal)
            flavor = "Apple"
        }
        else if appleSelect == true{
            appleSelect = false;
            sender.setImage(UIImage(named: "apple"), for: UIControl.State.normal)
            flavor = ""
        }
    }
    
    @IBAction func chocolateSelection(_ sender: UIButton) {
        
        appleToggleOff()
        cinnamonToggleOff()
        vanillaToggleOff()
        lemonToggleOff()
        coffeeToggleOff()
        mintToggleOff()
        strawberryToggleOff()
        bananaToggleOff()
        
        if chocolateSelect == false{
            chocolateSelect = true
            sender.setImage(UIImage(named:"chocolate_selected"), for: UIControl.State.normal)
            flavor = "Chocolate"
        }
        else if chocolateSelect == true{
            chocolateSelect = false;
            sender.setImage(UIImage(named: "chocolate"), for: UIControl.State.normal)
            flavor = ""
        }
    }
    
    @IBAction func cinnamonSelection(_ sender: UIButton) {
        
        appleToggleOff()
        chocolateToggleOff()
        vanillaToggleOff()
        lemonToggleOff()
        coffeeToggleOff()
        mintToggleOff()
        strawberryToggleOff()
        bananaToggleOff()
        
        if cinnamonSelect == false{
            cinnamonSelect = true
            sender.setImage(UIImage(named:"cinnamon_selected"), for: UIControl.State.normal)
            flavor = "Cinnamon"
        }
        else if cinnamonSelect == true{
            cinnamonSelect = false;
            sender.setImage(UIImage(named: "cinnamon"), for: UIControl.State.normal)
            flavor = "" 
        }
    }
    
    
    @IBAction func vanillaSelection(_ sender: UIButton) {
        
        appleToggleOff()
        chocolateToggleOff()
        cinnamonToggleOff()
        lemonToggleOff()
        coffeeToggleOff()
        mintToggleOff()
        strawberryToggleOff()
        bananaToggleOff()
        
        if vanillaSelect == false{
            vanillaSelect = true
            sender.setImage(UIImage(named:"vanilla_selected"), for: UIControl.State.normal)
            flavor = "Vanilla"
        }
        else if vanillaSelect == true{
            vanillaSelect = false;
            sender.setImage(UIImage(named: "vanilla"), for: UIControl.State.normal)
            flavor = ""
        }
    }
    
    
    @IBAction func lemonSelection(_ sender: UIButton) {
        
        appleToggleOff()
        chocolateToggleOff()
        cinnamonToggleOff()
        vanillaToggleOff()
        coffeeToggleOff()
        mintToggleOff()
        strawberryToggleOff()
        bananaToggleOff()
        
        if lemonSelect == false{
            lemonSelect = true
            sender.setImage(UIImage(named:"lemon_selected"), for: UIControl.State.normal)
            flavor = "Lemon"
        }
        else if lemonSelect == true{
            lemonSelect = false;
            sender.setImage(UIImage(named: "lemon"), for: UIControl.State.normal)
            flavor = ""
        }
    }
    
    @IBAction func coffeeSelection(_ sender: UIButton) {
        
        appleToggleOff()
        chocolateToggleOff()
        cinnamonToggleOff()
        vanillaToggleOff()
        lemonToggleOff()
        mintToggleOff()
        strawberryToggleOff()
        bananaToggleOff()
        
        if coffeeSelect == false{
            coffeeSelect = true
            sender.setImage(UIImage(named:"coffee_selected"), for: UIControl.State.normal)
            flavor = "Coffee"
        }
        else if coffeeSelect == true{
            coffeeSelect = false;
            sender.setImage(UIImage(named: "lemon"), for: UIControl.State.normal)
            flavor = ""
        }
    }
    
    @IBAction func mintSelection(_ sender: UIButton) {
        
        appleToggleOff()
        chocolateToggleOff()
        cinnamonToggleOff()
        vanillaToggleOff()
        lemonToggleOff()
        coffeeToggleOff()
        strawberryToggleOff()
        bananaToggleOff()
        
        if mintSelect == false{
            mintSelect = true
            sender.setImage(UIImage(named:"mint_selected"), for: UIControl.State.normal)
            flavor = "Mint"
        }
        else if mintSelect == true{
            mintSelect = false;
            sender.setImage(UIImage(named: "mint"), for: UIControl.State.normal)
            flavor = ""
        }
    }
    
    @IBAction func strawberrySelection(_ sender: UIButton) {
        
        appleToggleOff()
        chocolateToggleOff()
        cinnamonToggleOff()
        vanillaToggleOff()
        lemonToggleOff()
        coffeeToggleOff()
        mintToggleOff()
        bananaToggleOff()
        
        if strawberrySelect == false{
            strawberrySelect = true
            sender.setImage(UIImage(named:"strawberry_selected"), for: UIControl.State.normal)
            flavor = "Strawberry"
        }
        else if strawberrySelect == true{
            strawberrySelect = false;
            sender.setImage(UIImage(named: "strawberry"), for: UIControl.State.normal)
            flavor = ""
        }
    }
    
    @IBAction func bananaSelection(_ sender: UIButton) {
        
        appleToggleOff()
        chocolateToggleOff()
        cinnamonToggleOff()
        vanillaToggleOff()
        lemonToggleOff()
        coffeeToggleOff()
        mintToggleOff()
        strawberryToggleOff()
        
        if bananaSelect == false{
            bananaSelect = true
            sender.setImage(UIImage(named:"banana_selected"), for: UIControl.State.normal)
            flavor = "Banana"
        }
        else if bananaSelect == true{
            bananaSelect = false;
            sender.setImage(UIImage(named: "banana"), for: UIControl.State.normal)
            flavor = ""
        }
    }




}

