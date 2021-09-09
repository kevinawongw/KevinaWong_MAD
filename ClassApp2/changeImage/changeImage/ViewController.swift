//
//  ViewController.swift
//  changeImage
//
//  Created by Kevina Wong on 8/31/21.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var artImage: UIImageView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func chooseImage(_ sender: UIButton) {
        if sender.tag == 1{
            artImage.image = UIImage(named: "itachi")
        }
        else if sender.tag == 2{
            artImage.image = UIImage(named: "sasuke")
        }
        
    }
    
    
}

