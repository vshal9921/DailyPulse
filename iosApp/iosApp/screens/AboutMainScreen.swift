//
//  AboutMainScreen.swift
//  iosApp
//
//  Created by Vishal Gupta on 09/11/25.
//

import Shared
import SwiftUI

struct AboutMainScreen: View {
    var body: some View {
        NavigationStack{
            AboutScreen()
                .navigationTitle("About Device")
        }
    }
}

#Preview {
    AboutMainScreen()
}
