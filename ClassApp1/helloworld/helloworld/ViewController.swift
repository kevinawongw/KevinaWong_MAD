//
//  ViewController.swift
//  helloworld
//
//  Created by Kevina Wong on 8/26/21.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var helloWorldLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func sayHello(_ sender: UIButton){
        helloWorldLabel.text = "Hello World :)"
    }
    
}

