//
//  PetCatItemRow.swift
//  iosApp
//
//  Created by HoangChung on 23/7/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import common

struct PetCatItemRow : View {
    
    var items : PetModel
    
    var body: some View {
        HStack {
            AsyncImage(url: URL(string: items.url)) { image in
                 image.resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 64, height: 64)
            } placeholder: {
                ProgressView()
            }
            
            VStack(alignment: .leading) {
                Text(items.id).font(.headline)
                Text(items.name).font(.subheadline)
            }
            Spacer()
            Text(String(items.name))
        }
    }
}
