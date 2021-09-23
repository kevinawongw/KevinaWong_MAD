//
//  ViewController.swift
//  tipCalculator
//
//  Created by Kevina Wong on 9/23/21.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate {
    
    /*
     Outlets and Actions
     */
    
    @IBOutlet weak var checkAmount: UITextField!
    
    @IBOutlet weak var tipPercentage: UITextField!
    
    @IBOutlet weak var peopleLabel: UILabel!
    
    @IBOutlet weak var peopleStepper: UIStepper!
    
    @IBOutlet weak var totalTip: UILabel!
    
    @IBOutlet weak var TotalBill: UILabel!
    
    @IBOutlet weak var TotalPerPerson: UILabel!
    /*
     Functions
     */
    
    func updateTipTotals(){
        var totalAmount:Float
        var percent: Float
        
        if checkAmount.text!.isEmpty {
            totalAmount = 0.0
        }
        else{
            totalAmount = Float(checkAmount.text!)!
        }
        
        if tipPercentage.text!.isEmpty {
            percent = 0.0
        }
        else {
            percent = Float(tipPercentage.text!)!/100
        }
        
        let numberOfPeople = peopleStepper.value
        let tip = totalAmount * percent
        let total = totalAmount + tip
        var personTotal: Float = 0.0
        if numberOfPeople > 0 {
            personTotal = total / Float(numberOfPeople)
        }
        else{
            let alert = UIAlertController(title: "Warning", message: "The number of people must be grester than 0", preferredStyle: UIAlertController.Style.alert)
            
            let cancelAction = UIAlertAction(title: "Cancel", style: UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            let okAction = UIAlertAction(title: "Ok", style: UIAlertAction.Style.default, handler: {
                action in
                self.peopleStepper.value = 1
                self.peopleLabel.text = "1"
                self.updateTipTotals()
            })
            alert.addAction(okAction)
            present(alert,animated:true, completion: nil)
        }
        
        let currencyFormatter = NumberFormatter()
        currencyFormatter.numberStyle = NumberFormatter.Style.currency
        
        totalTip.text = currencyFormatter.string(from: NSNumber (value : tip))
        
        TotalBill.text = currencyFormatter.string(from: NSNumber (value : total))
        
        TotalPerPerson.text = currencyFormatter.string(from: NSNumber (value : personTotal))
        
    }

    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    func textFieldDidEndEditing(_ textField: UITextField, reason: UITextField.DidEndEditingReason) {
        <#code#>
    }
    
    @IBAction func updatePeople(_ sender: UIStepper) {
        if peopleStepper.value == 1{
            peopleLabel.text = "1 person"
        }
        else{
            peopleLabel.text = String(format: "%.0f",peopleStepper.value) + " people"
        }
        updateTipTotals()
    }
    
    
    
    /*
     Startup
     */
    override func viewDidLoad() {
        checkAmount.delegate = self
        tipPercentage.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
    }


}

