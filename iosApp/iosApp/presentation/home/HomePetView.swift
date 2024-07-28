//
//  HomePetView.swift
//  iosApp
//
//  Created by HoangChung on 21/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import common

extension PetModel : Identifiable {
    
}

struct HomeView : View {
    
    @ObservedObject
    var viewModel: SwiftHomeViewModel = SwiftHomeViewModel()
    
    @StateObject var viewModelStoreOwner = SharedViewModelStoreOwner<HomePetViewModel>()
    
    var body: some View {
        if #available(iOS 16.0, *) {
            NavigationStack {
                VStack(alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/, content: {
                    
                    Observing(viewModelStoreOwner.instance.statePetModel) { petList in
                        PetCatItemsList(items: petList)
                    }
                    
                    Text(viewModel.message)
                }).task {
                    
                    
                }
            }.task {
                await viewModel.activate()
            }
        }
    }
}
