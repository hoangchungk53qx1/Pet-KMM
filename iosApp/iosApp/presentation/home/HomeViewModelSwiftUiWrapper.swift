//
//  HomeViewModelWrapper.swift
//  iosApp
//
//  Created by HoangChung on 10/8/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import common
import SwiftUI


class HomeViewModelSwiftUiWrapper : ObservableObject {
    var viewModelStoreOwner = SharedViewModelStoreOwner<HomePetViewModel>()
    
    var viewModel  : HomePetViewModel
        
    @Published
    private(set) var petList =  []
    
    init() {
        let viewModel = viewModelStoreOwner.instance
        self.viewModel = viewModel
    }
    
    func getFirstPagePet() {
        viewModel.getPetFirstList()
    }
    
    func onCleared() {
        viewModel.onCleared()
    }
    
}
