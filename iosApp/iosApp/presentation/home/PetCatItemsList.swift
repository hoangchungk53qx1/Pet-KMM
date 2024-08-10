//
//  PetCatItemsList.swift
//  iosApp
//
//  Created by HoangChung on 23/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import common
import SwiftUI

struct PetCatItemsList : View {
    let items:  [PetModel]

    var body: some View {
        List {
            ForEach(items, id: \.id) { pet in
                HStack(content: {
                    AsyncImage(url: URL(string: pet.url)) { image in
                                image.resizable()
                                   .aspectRatio(contentMode: .fit)
                                   .frame(width: 64, height: 64)
                           } placeholder: {
                               ProgressView()
                           }
                    Text(pet.name)
                    Spacer()
                    Text(pet.description_)
                })
            }
        }
    }
}
