//
//  PathView.swift
//  iosApp
//
//  Created by ws-071-11b on 2/7/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import PizzaBotCore

struct PathView: View {
    
    
    @Binding var matrix: MatrixPathModel
    
    var body: some View {
        HStack {
            GeometryReader { (geometry) in
                self.makeView(geometry)
            }
        }
        
    }
    
    func makeView(_ geometry: GeometryProxy) -> some View {
        
        
        return Path { path in
            path.move(to: CGPoint(x: 20, y: 0))
            path.addLine(to: CGPoint(x: 20, y: geometry.size.height-20))
            path.addLine(to: CGPoint(x: geometry.size.width-20, y: geometry.size.height-20))
            
            if(!matrix.path.isEmpty){
                path.move(to: CGPoint(x: geometry.size.width-20, y: geometry.size.height-20))
                
                let delta = CGFloat(Float(min(geometry.size.width, geometry.size.height)) / Float(max(matrix.matrixModel.height, matrix.matrixModel.width)))
                
                var currentX:CGFloat = 20
                var currentY:CGFloat = geometry.size.height-20
                
                matrix.path.forEach { (PathEnum) in
                    switch PathEnum {
                    case.bottom: do {
                        path.addLine(to: CGPoint(x: currentX, y: currentY))
                        currentY = currentY + delta
                        }
                    case.right: do {
                        path.addLine (to: CGPoint(x: currentX, y: currentY))
                        currentX = currentX+delta
                        }
                    case.top:do {
                        path.addLine(to: CGPoint(x: currentX, y: currentY))
                        currentY = currentY - delta
                        }
                    case.drop:do {
                        path.addArc(center: CGPoint(x: currentX, y: currentY), radius: 1.0, startAngle: Angle(radians: 0), endAngle: Angle(radians: .pi*2), clockwise: false)
                        path.move(to: CGPoint(x: currentX, y: currentY))
                        }
                        
                    default: break
                        
                    }
                }
            }
            
            
            
        }
        .stroke(lineWidth: 2)
    }
    
}

