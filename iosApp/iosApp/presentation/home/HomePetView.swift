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
    
    init() {
        viewModelStoreOwner.instance.getPetFirstList()
    }
    
    var body: some View {
        if #available(iOS 16.0, *) {
            NavigationStack {
                VStack(alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/, content: {
                    Observing(viewModelStoreOwner.instance.statePetModel) { state in
                        switch state {
                        case _ as HomePetUiStateLoadingFirstPage:
                            ProgressView()
                        case let fristPageSuccess as HomePetUiStateLoadPageSuccess:
                            PetCatItemsList(items: fristPageSuccess.petList)
                        case let loadingNextPage as HomePetUiStateNextPageStateLoading:
                            ProgressView()
                        default:
                            EmptyView()
                        }
                    }
                    
                }).task {
                    
                }
            }.task {
                //                await viewModelStoreOwner.instance.getPetFirstList()
            }
        }
    }
}
