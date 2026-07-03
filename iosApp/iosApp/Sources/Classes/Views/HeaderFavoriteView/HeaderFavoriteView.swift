import SwiftUI

struct HeaderFavoriteView: View {
    
    let title: String
    let action: () -> Void
    
    var body: some View {
        HStack(spacing: 16) {
            VStack {
                Text(title)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .font(Font.system(size: 16, weight: .bold))
                Spacer()
            }
            VStack {
                Button(action: action) {
                    Image(systemName: "star")
                        .renderingMode(.original)
                        .resizable()
                        .frame(width: 24, height: 24)
                        .scaledToFill()
                }
                .frame(width: 44, height: 44)
                .background(Color.black.opacity(0.7))
                .cornerRadius(15)                
                Spacer()
            }
        }
    }
}
