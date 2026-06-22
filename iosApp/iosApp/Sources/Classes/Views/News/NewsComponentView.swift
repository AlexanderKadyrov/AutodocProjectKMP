import SharedLogic
import SwiftUI

struct NewsComponentView: View {
    
    var model: NewsModel
    
    var body: some View {
        VStack(alignment: .leading, spacing: .zero) {
            
            VStack(alignment: .leading, spacing: 16) {
                
                VStack(alignment: .leading, spacing: 16) {
                    
                    Text(model.title)
                        .frame(maxWidth: .infinity, alignment: .leading)
                        .font(Font.system(size: 16, weight: .bold))
                    
                    Text(model.descriptions)
                        .frame(maxWidth: .infinity, alignment: .leading)
                        .font(Font.system(size: 14))
                    
                    HStack(alignment: .center, spacing: 16) {
                        
                        Text(model.publishedDate)
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .font(Font.system(size: 12))
                        
                        ZStack(alignment: .center) {
                            Text(model.categoryType)
                                .padding(EdgeInsets(top: 2, leading: 8, bottom: 2, trailing: 8))
                                .foregroundStyle(Color(hex: "FFFFFF"))
                                .font(Font.system(size: 12))
                                .lineLimit(1)
                        }
                        .background(Color(hex: "EE6B6E"))
                    }
                }
                .padding([.leading, .trailing], 16)
                
                AsyncImage(url: URL(string: model.titleImageUrl ?? "")) { image in
                    image
                        .resizable()
                        .aspectRatio(contentMode: .fill)
                } placeholder: {
                    
                }
                .cornerRadius(15)
            }
            .padding(.top, 16)
            .overlay {
                RoundedRectangle(cornerRadius: 15)
                    .stroke(Color(hex: "808080"), lineWidth: 1)
            }
        }
    }
}
