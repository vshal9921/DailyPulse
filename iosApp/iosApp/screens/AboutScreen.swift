//
//  AboutScreen.swift
//  iosApp
//
//  Created by Vishal Gupta on 09/11/25.
//

import Shared
import SwiftUI

struct AboutScreen: View{
    
    @Environment(\.dismiss)
    private var dismiss
   
    private struct RowItem: Hashable{
        let title: String
        let subtitle: String
    }
    
    private let items: [RowItem] = {
        
        let platform = Platform()
        platform.logSystemInfo()
        
        var result : [RowItem]  = [
            .init(title: "Operating System",
                  subtitle: "\(platform.osName) \(platform.osVersion)"
                 ),
            .init(title: "Device name",
                  subtitle: platform.deviceModel
                 ),
            .init(title: "Density",
                  subtitle:"@\(platform.density)x"
                 )
        ]
                  return result
    }()
    
    var body: some View{
        NavigationStack{
            List{
                ForEach(items, id: \.self){ item in
                    VStack(alignment: .leading){
                        Text(item.title)
                            .font(.footnote)
                            .foregroundStyle(.secondary)
                        Text(item.subtitle)
                            .font(.body)
                            .foregroundStyle(.primary)
                    }
                    .padding(.vertical, 4)
                    
                }
            }.toolbar{
                ToolbarItem(placement: .primaryAction){
                    Button{
                        dismiss()
                    } label: {
                        Text("Done").bold()
                    }
                }
            }
        }
        
    }
}

#Preview {
    AboutScreen()
}
