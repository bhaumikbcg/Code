package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 2;
    int price = 0;
    int cream = 0;
    int choc = 0;

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        Editable a = name.getText();
        CheckBox cream = (CheckBox) findViewById(R.id.box);
        boolean hasCream = cream.isChecked();
        CheckBox chocolate = (CheckBox) findViewById(R.id.choc);
        boolean hasChoc = chocolate.isChecked();
        if (hasCream) {
            this.cream = 1;
        }
        if (hasChoc) {
            this.choc = 2;
        }
        price = calculatePrice(this.cream, this.choc);
        String priceMessage = createOrderSummary(price, hasCream, hasChoc, a);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + a);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calculatePrice(int cream, int choc) {
        return quantity * (5 + cream + choc);
    }

    public String createOrderSummary(int price, boolean hasCream, boolean hasChoc, Editable a){
        return "Name: " + a + "\nQuantity: " + quantity + "\nHas Whipped Cream? " +hasCream + "\nHas Chocolate? "
                +hasChoc + "\nTotal: $" + price + "\nThank you!";
    }

    public void increment(View view) {
        if(quantity==100){
            Toast.makeText(this, "Cannot take more than 100 orders", Toast.LENGTH_SHORT).show();
            return;
        }
            quantity += 1;
            displayQuantity(quantity);
    }
    public void decrement(View view) {
        if(quantity==1){
            Toast.makeText(this, "Cannot take less than 1 order", Toast.LENGTH_SHORT).show();
            return;
        }
            quantity -= 1;
            displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */

}
