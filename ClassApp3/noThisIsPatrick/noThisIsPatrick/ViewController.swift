//
//  ViewController.swift
//  noThisIsPatrick
//
//  Created by Kevina Wong on 9/9/21.
//

import UIKit

class ViewController: UIViewController {
    
    // Outlets

    @IBOutlet weak var appImage: UIImageView!
    
    @IBOutlet weak var appLabel: UILabel!
    
    @IBOutlet weak var fontSizeLabel: UILabel!
    
    @IBOutlet weak var segmentedControl: UISegmentedControl!

    @IBOutlet weak var capsSwitch: UISwitch!
    
    // Load
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    // Methods
    
    func updateImage(){
        if segmentedControl.selectedSegmentIndex == 1{
            appLabel.text = "no this is patrick"
            appImage.image = UIImage(named: "thisIsPatrick")
        }
        
        else if segmentedControl.selectedSegmentIndex == 0{
            appLabel.text = "is this the krusty krab"
            appImage.image = UIImage(named: "krustyKrab")
        }
    }
    
    func capitalizeText(){
        if capsSwitch.isOn {
            appLabel.text = appLabel.text?.uppercased()
        }
        else {
            appLabel.text = appLabel.text?.lowercased()
        }
    }

    // Actions
    
    @IBAction func changeInfo(_ sender: UISegmentedControl) {
        updateImage()
        if capsSwitch.isOn{
            appLabel.text = appLabel.text?.uppercased()
        }
    }
    @IBAction func changeCaps(_ sender: UISwitch) {
        capitalizeText()
    }
    
    @IBAction func changeFontSize(_ sender: UISlider) {
        let fontSize = sender.value
        fontSizeLabel.text = String(format: "%.0f", fontSize)
        let fontSizeCGFloat = CGFloat(fontSize)
        appLabel.font = UIFont.systemFont(ofSize: fontSizeCGFloat)
    }
    
}

