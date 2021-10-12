//
//  dessertPopUp.swift
//  bunnyBake
//
//  Created by Kevina Wong on 10/1/21.
//

import UIKit
import AVFoundation


class dessertPopUp: UIViewController {
    

    var user = userChoices()
    var audioPlayer: AVAudioPlayer?

    
    @IBOutlet weak var dessertText: UITextField!
    @IBOutlet weak var dessertImage: UIImageView!
    @IBOutlet weak var wowBunny: UIImageView!
    
    var recipe = ""
    var image = "" 
    
    @IBAction func unwindSegue (_ segue:UIStoryboardSegue){
        let scene1ViewController = segue.destination as! ViewController
        scene1ViewController.resetAll()
    }
    

    @IBAction func shareButton(_ sender: UIButton) {
        let myRecipe = recipe
        let myImage = UIImage(named: image)

        // Code reference from stack overflow to show how to share a screenshot
        // https://stackoverflow.com/questions/32188822/taking-screenshot-and-share-with-share-button
        
        let bounds = UIScreen.main.bounds
        UIGraphicsBeginImageContextWithOptions(bounds.size, true, 0.0)
        self.view.drawHierarchy(in: bounds, afterScreenUpdates: false)
        let img = UIGraphicsGetImageFromCurrentImageContext()
        UIGraphicsEndImageContext()

        let activityViewController =
            UIActivityViewController(activityItems: [img ?? myImage!, myRecipe],
                                     applicationActivities: nil)
        
        self.present(activityViewController, animated: true, completion: nil)
        
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    
    
    
    @IBAction func bakeAgainButton(_ sender: UIButton) {
        let bubbleSound = Bundle.main.path(forResource: "bubble", ofType: "wav")!
        let url = URL(fileURLWithPath: bubbleSound)
        
        do{
        audioPlayer = try AVAudioPlayer(contentsOf: url)
        audioPlayer?.play()
        }
        catch{
            // do nothing
        }
        self.dismiss(animated: true, completion: nil)
    }
    
    
}
