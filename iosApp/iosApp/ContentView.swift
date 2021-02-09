import SwiftUI
import PizzaBotCore

struct ContentView: View {
    
    @State private var secondNum: String = ""
    
    @State private var showAlert = false
    @State private var errorMessage = ""
    
    @State private var matrix: MatrixPathModel = MatrixPathModel(matrixModel: MatrixModel(height: 10, width: 10),path: [])
    
    var body: some View {
        VStack {
                PathView(matrix: $matrix)
                HStack() {
                    TextField("InputPath", text: $secondNum)
                        .keyboardType(.default)
                        .textFieldStyle(RoundedBorderTextFieldStyle())
                        .multilineTextAlignment(.center)
                }
                Button(action: {
                    do {
                       self.matrix = try PathControllerImpl().getPathWithMatrix(input: self.secondNum)
                    }catch {
                        self.errorMessage = error.localizedDescription
                        self.showAlert = true
                        print(error)
                    }
                }) {
                    Text("Draw path")
                        .fontWeight(.semibold)
                        .font(.title)
                }
                .frame(minWidth: 0, maxWidth: .infinity)
                .padding(16)
                .foregroundColor(.white)
                .background(Color.red)
                .cornerRadius(CGFloat(40.0))
            }.alert(isPresented: $showAlert) {
                Alert(title: Text("Error"), message: Text(self.errorMessage), dismissButton: .default(Text("Ok")))
            }
        .padding(.bottom, 16)
        .keyboardAware()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
