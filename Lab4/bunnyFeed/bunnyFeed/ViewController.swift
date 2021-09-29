//
//  ViewController.swift
//  bunnyFeed
//
//  Created by Kevina Wong on 9/29/21.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {

    
    
    
    @IBOutlet weak var bunnyImage: UIImageView!
    
    @IBOutlet weak var cakeCount: UILabel!
    @IBOutlet weak var donutCount: UILabel!
    @IBOutlet weak var puddingCount: UILabel!
    var bunnyName: String = "Bunny"
    @IBOutlet weak var sentence: UILabel!
    var status: String = "hungry"
    @IBOutlet weak var nameInput: UITextField!
    @IBOutlet weak var happinessPoints: UILabel!
    @IBOutlet weak var cakeStepper: UIStepper!
    @IBOutlet weak var donutStepper: UIStepper!
    @IBOutlet weak var pupddingStepper: UIStepper!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        bunnyImage.loadGif(name:"hungryBunny")
        nameInput.delegate = self
        
         NotificationCenter.default.addObserver(self, selector:
        #selector(keyboardWillHide), name: UIResponder.keyboardWillHideNotification,object: nil)
        
        let tap: UITapGestureRecognizer =
        UITapGestureRecognizer(target: self, action:
        #selector(self.dismissKeyboard))
         view.addGestureRecognizer(tap)
    }
    
    @objc func dismissKeyboard() {
     view.endEditing(true)
     }
    
     @objc func keyboardWillHide(notification: NSNotification) {
     if ((notification.userInfo?[UIResponder.keyboardFrameEndUserInfoKey] as? NSValue)?.cgRectValue)
         != nil {
             if self.view.frame.origin.y != 0 {
                self.view.frame.origin.y = 0
             }
         }
     }
    
    
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    func textFieldDidEndEditing(_ textField: UITextField, reason: UITextField.DidEndEditingReason) {
    }
    
    func updateSentence(bunnyName:String, status:String){
        sentence.text = "\(bunnyName) is \(status)!"
    }
    
    func checkFood(CC:Int, DC:Int, PC:Int){
        var status: String = ""
        let foodTotal: Int = CC + DC + PC
        
        if foodTotal == 0{
            status = "hungry"
            bunnyImage.image = UIImage(named: "hungryBunny")
            bunnyImage.loadGif(name:"hungryBunny")

        }
        else if foodTotal > 0 && foodTotal < 10{
            status = "eating"
            bunnyImage.image = UIImage(named: "eatingBunny")
            bunnyImage.loadGif(name:"eatingBunny")
        }
        else{
            status = "in a food coma"
            donutStepper.isEnabled = false
            pupddingStepper.isEnabled = false
            cakeStepper.isEnabled = false
            bunnyImage.image = UIImage(named: "foodComaBunny")
            bunnyImage.loadGif(name:"foodComaBunny")

            let alert = UIAlertController(title: "Uh Oh!", message: "\(bunnyName) has eaten too much. Reset \(bunnyName) so it can eat again!", preferredStyle: UIAlertController.Style.alert)
            
            let cancelAction = UIAlertAction(title: "Watch \(bunnyName)", style: UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction = UIAlertAction(title: "Reset \(bunnyName)", style: UIAlertAction.Style.default, handler: {
                action in
                self.resetAll()
            })
            alert.addAction(okAction)
            present(alert,animated:true, completion: nil)

        }
        updateSentence(bunnyName: bunnyName, status: status)
        happinessPoints.text = String(CC + (2 * DC) + (3 * PC))
    }
    
    @IBAction func changeName(_ sender: UITextField) {
        let name:String = sender.text!
        bunnyName = name
        updateSentence(bunnyName: bunnyName, status: status)
    }
    
    
    @IBAction func cakeIncrement(_ sender: UIStepper) {
        cakeCount.text = String(format: "%.0f",cakeStepper.value)
        checkFood(CC:Int(cakeStepper.value), DC:Int(donutStepper.value), PC:Int(pupddingStepper.value))
    }
    
    @IBAction func donutIncrement(_ sender: UIStepper) {
        donutCount.text = String(format: "%.0f",donutStepper.value)
        checkFood(CC:Int(cakeStepper.value), DC:Int(donutStepper.value), PC:Int(pupddingStepper.value))
    }
    
    @IBAction func puddingIncrement(_ sender: UIStepper) {
        puddingCount.text = String(format: "%.0f",pupddingStepper.value)
        checkFood(CC:Int(cakeStepper.value), DC:Int(donutStepper.value), PC:Int(pupddingStepper.value))
        
    }
    
    func resetAll(){
        cakeStepper.value = 0
        cakeCount.text = "0"
        donutStepper.value = 0
        donutCount.text = "0"
        pupddingStepper.value = 0
        puddingCount.text = "0"
        bunnyName = "Bunny"
        checkFood(CC: 0, DC: 0, PC: 0)
        donutStepper.isEnabled = true
        pupddingStepper.isEnabled = true
        cakeStepper.isEnabled = true
        nameInput.text = ""
    }

    @IBAction func reset(_ sender: UIButton) {
        resetAll()
    }
}

