import SharedLogic
import SwiftUI

struct NewsComponentView: View {
    
    var viewModel: NewsEntityViewModel
    
    let onFavoriteAction: () -> Void
    let onTapAction: () -> Void
    
    var body: some View {
        Button(action: onTapAction) {
            componentView()
        }
    }
    
    @ViewBuilder
    private func componentView() -> some View {
        VStack(alignment: .leading, spacing: .zero) {
            
            VStack(alignment: .leading, spacing: .zero) {
                
                VStack(alignment: .leading, spacing: 16) {
                    
                    HeaderFavoriteView(
                        title: viewModel.entity.title,
                        onFavoriteAction: onFavoriteAction
                    )
                    
                    Text(viewModel.entity.descriptions)
                        .frame(maxWidth: .infinity, alignment: .leading)
                        .font(Font.system(size: 14))
                    
                    HStack(alignment: .center, spacing: 16) {
                        
                        Text(viewModel.entity.publishedDate)
                            .frame(maxWidth: .infinity, alignment: .leading)
                            .font(Font.system(size: 12))
                        
                        ZStack(alignment: .center) {
                            Text(viewModel.entity.categoryType)
                                .padding(EdgeInsets(top: 2, leading: 8, bottom: 2, trailing: 8))
                                .fixedSize(horizontal: true, vertical: false)
                                .foregroundStyle(Color(hex: "FFFFFF"))
                                .font(Font.system(size: 12))
                                .lineLimit(1)
                        }
                        .background(Color(hex: "EE6B6E"))
                    }
                }
                .padding([.leading, .trailing, .bottom], 16)

                if let source = viewModel.entity.titleImageUrl, let url = URL(string: source) {
                    CachedAsyncImage(url: url) { image in
                        image
                            .resizable()
                            .aspectRatio(contentMode: .fill)
                    } placeholder: {
                        Image("icNewsPlaceholder")
                            .resizable()
                            .aspectRatio(contentMode: .fill)
                    }
                    .cornerRadius(15)
                }
            }
            .padding(.top, 16)
            .overlay {
                RoundedRectangle(cornerRadius: 15)
                    .stroke(Color(hex: "808080"), lineWidth: 1)
            }
        }
    }
}
