//
//  ViewController.swift
//  pokemonEvolve
//
//  Created by Kevina Wong on 9/1/21.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var appImage: UIImageView!
    
    @IBOutlet weak var appText: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func changeImageAndText(_ sender: UIButton) {
        
        if sender.tag == 1{
            appImage.image = UIImage(named: "pikachu")
            appText.text = "Ditto transformed to Pikachu!"
        }
        else if sender.tag == 2{
            appImage.image = UIImage(named: "psyduck")
            appText.text = "Ditto transformed to Psyduck!"
        }
        else if sender.tag == 3{
            appImage.image = UIImage(named: "snorlax")
            appText.text = "Ditto transformed to Snorlax!"
        }
        else if sender.tag == 4{
            appImage.image = UIImage(named: "sudowoodoo")
            appText.text = "Ditto transformed to Sudowoodoo!"
        }
        else if sender.tag == 5{
            appImage.image = UIImage(named: "ditto")
            appText.text = "Ditto transformed back!"
        }
        
        
    }
    
}

