package de.constantinuous.structipus.metrics.sourcecode;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.comments.Comment;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.TypeDeclarationStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.InputStream;

/**
 * Created by RichardG on 17.12.2015.
 */
public class AstMetricCounter extends VoidVisitorAdapter {

    public int getMcCabe() {
        return mcCabe;
    }

    private int mcCabe = 0;

    public AstMetricCounter(InputStream fileInputStream) throws ParseException {
        CompilationUnit cu = JavaParser.parse(fileInputStream);
        visit(cu, null);
    }


    @Override
    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
        super.visit(n, arg);
        // here you can access the attributes of the method.
        // this method will be called for all methods in this
        // CompilationUnit, including inner class methods
        System.out.println("Class: "+n.getName()+" ");
    }

    @Override
    public void visit(MethodDeclaration n, Object arg) {
        super.visit(n, arg);
        // here you can access the attributes of the method.
        // this method will be called for all methods in this
        // CompilationUnit, including inner class methods
        System.out.println(n.getName());
    }

    @Override
    public void visit(MethodCallExpr n, Object arg) {
        super.visit(n, arg);
        // here you can access the attributes of the method.
        // this method will be called for all methods in this
        // CompilationUnit, including inner class methods
        System.out.println("MethodCall: "+n.getName());
        mcCabe++;
    }

    @Override
    public void visit (ExpressionStmt stmt, Object args)
    {
        Comment comment = stmt.getComment();

        super.visit(stmt, args);

    }

    @Override
    public void visit (TypeDeclarationStmt stmt, Object args)
    {
        super.visit(stmt,args);
    }
}
