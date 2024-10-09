//
//  DetailPetViewModel.swift
//  iosApp
//
//  Created by HoangChung on 9/10/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation

class DetailPetViewModelWrapper : ObservableObject {
    var detailViewModel = SharedViewModelStoreOwner<HomePetViewModel>()
    
}
