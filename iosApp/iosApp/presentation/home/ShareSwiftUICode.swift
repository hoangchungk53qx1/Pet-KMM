//
//  ShareSwiftUICode.swift
//  iosApp
//
//  Created by HoangChung on 28/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import common

class SwiftHomeViewModel: ObservableObject {
//    
    var viewModelStoreOwner = SharedViewModelStoreOwner<HomePetViewModel>()
//    
    var viewModel: HomePetViewModel
    
    @Published
    private(set) var message:String = ""

    init() {
        self.message = "Hello World"
        let viewModel = viewModelStoreOwner.instance
        self.viewModel = viewModel
    }
    
    @MainActor
    func activate() async {
                
    }

    func deactivate() {
   
    }
}
