//Name : Alphonsa George
//Assignment : PROG1403HW3

import java.util.Scanner;

public class Colors
{
    /**
     * Represents the lowest value of temperature.
     */
    public static final int MIN_TEMPERATURE = 0;

    /**
     * Represents the highest value of temperature
     */
    public static final int MAX_TEMPERATURE = 100;

    /**
     * Represents the Minimum value of temperature between the colors
     * blue and cyan
     */
    public static final int BLUE_MIN = 0;

    /**
     * Represents the maximum value of temperature between
     * colors blue and cyan
     */
    public static final int BLUE_MAX = 25;

    /**
     * Represents the Maximum value of temperature which represents
     * the Color Green
     */
    public static final int GREEN_MAX = 50;

    /**
     * Represents the Maximum value of temperature which represents
     *  the Color Yellow
     */
    public static final int YELLOW_MAX = 75;

    /**
     * Represents the Maximum value of temperature which represents
     * the Color Red
     */
    public static final int RED_MAX = 100;

    /**
     * Represents the lowest RGB value
     */
    public static final int MIN_RGB_VALUE = 0;

    /**
     * Represents the highest RGB value
     */
    public static final int MAX_RGB_VALUE = 255;

    /**
     * Represents a constant to be used while calculating color value
     */
    public static final int COLOR_NUMBER_MULTIPLICAND_ONE = 65536;

    /**
     * Represents another constant used while calculating color value
     */
    public static final int COLOR_NUMBER_MULTIPLICAND_TWO = 256;


    /**
     * Gets the input from the user and checks whether it is an integer or not
     * comes out of the loop only if it is a valid integer value.
     * @param prompt the prompt given in the output stream to the user
     * @return returns an integer value.
     */
    public static int getValidTemperature(String prompt)
    {
        System.out.printf(prompt);
        var scanner = new Scanner(System.in);
        while (!scanner.hasNextInt())
        {
            System.out.println("Invalid entry, try again!:");
            scanner.nextLine();
            System.out.printf(prompt);
        }

        return scanner.nextInt();
    }

    /**
     * Gets the valid integer input from the user and checks whether it is in the acceptable
     * range within a certain min and max values or not.
     * @param prompt the prompt given in the output stream to the user
     * @param min Minimum value temperature can take
     * @param max Maximum value temperature can take
     * @return returns an integer value of temperature which is within range.
     */
    public static int getValidTemperature(String prompt, int min, int max)
    {
        do {
            var temperature = getValidTemperature(prompt);
            var isWithinRange = temperature >= MIN_TEMPERATURE && temperature <= MAX_TEMPERATURE;
            if(!isWithinRange)
            {
                System.out.println("Invalid range, try again! ");
            }
            else
            {
                return temperature;
            }
        }while(true);
    }

    /**
     * Calculates the Z value for the given temperature
     * @param temperature Temperature for which the particular Z value
     *                    to be calculated
     * @return returs the Z value for the given temperature
     */
    public static double getValueZ(int temperature)
    {

        if (temperature >= BLUE_MIN && temperature <= BLUE_MAX)
        {
            return (((double)temperature - (double)BLUE_MIN) / ((double)BLUE_MAX - (double)BLUE_MIN));

        }
        else if (temperature > BLUE_MAX && temperature <= GREEN_MAX)
        {
            return (((double)temperature - (double) BLUE_MAX) / ((double)GREEN_MAX - (double)BLUE_MAX));
        }
        else if (temperature > GREEN_MAX && temperature <= YELLOW_MAX)
        {
            return (((double)temperature - (double)GREEN_MAX) / ((double)YELLOW_MAX - (double)GREEN_MAX));
        }
        else
        {
            return (((double)temperature - (double)YELLOW_MAX) / ((double)RED_MAX - (double)YELLOW_MAX));
        }
    }

    /**
     * calculates the Red RGB value of the given temperature
     * @param temperature temperature for which the Red value to be found
     * @param valueZ Z value of the given temperature
     * @return returns the Red value of the given temperature
     */
    public static int getRedValue(int temperature, double valueZ)
    {
        if (temperature >= BLUE_MIN && temperature <= BLUE_MAX)
        {
            return (int)(MIN_RGB_VALUE * valueZ + MIN_RGB_VALUE * (1-valueZ));

        }
        else if(temperature > BLUE_MAX && temperature <= GREEN_MAX)
        {
            return (int)(MIN_RGB_VALUE * valueZ + MIN_RGB_VALUE * (1-valueZ));
        }
        else if(temperature > GREEN_MAX && temperature <= YELLOW_MAX)
        {
            return (int)(MAX_RGB_VALUE * valueZ + MIN_RGB_VALUE * (1-valueZ));
        }
        else
        {
            return (int)(MAX_RGB_VALUE * valueZ + MAX_RGB_VALUE * (1-valueZ));
        }

    }

    /**
     * Calculates the Green RGB value of the given temperature
     * @param temperature temperature for which the Green value to be found
     * @param valueZ Z value of the given temperature
     * @return returns the Green value of the given temperature
     */
    public static int getGreenValue(int temperature, double valueZ)
    {
        if (temperature >= BLUE_MIN && temperature <= BLUE_MAX)
        {
            return (int)(MAX_RGB_VALUE * valueZ + MIN_RGB_VALUE * (1 - valueZ));

        }
        else if(temperature > BLUE_MAX && temperature <= GREEN_MAX)
        {
            return (int)(MAX_RGB_VALUE * valueZ + MAX_RGB_VALUE * (1 - valueZ));
        }
        else if(temperature > GREEN_MAX && temperature <= YELLOW_MAX)
        {
            return (int)(MAX_RGB_VALUE * valueZ + MAX_RGB_VALUE * (1 - valueZ));
        }
        else
        {
            return (int)(MIN_RGB_VALUE * valueZ + MAX_RGB_VALUE * (1 - valueZ));
        }

    }

    /**
     * Calculates the Blue RGB value of the given temperature
     * @param temperature temperature for which the Blue value to be found
     * @param valueZ Z value of the given temperature
     * @return returns the Blue value of the given temperature
     */

    public static int getBlueValue(int temperature, double valueZ)
    {
        if (temperature >= BLUE_MIN && temperature <= BLUE_MAX)
        {
            return (int) (MAX_RGB_VALUE * valueZ + MAX_RGB_VALUE * (1 - valueZ));

        }
        else if(temperature > BLUE_MAX && temperature <= GREEN_MAX)
        {
            return (int)(MIN_RGB_VALUE * valueZ + MAX_RGB_VALUE * (1 - valueZ));
        }
        else if(temperature > GREEN_MAX && temperature <= YELLOW_MAX)
        {
            return (int)(MIN_RGB_VALUE * valueZ + MIN_RGB_VALUE * (1 - valueZ));
        }
        else
        {
            return (int)(MIN_RGB_VALUE * valueZ + MIN_RGB_VALUE * (1- valueZ));
        }

    }

    /**
     * Displays the Red, Green and Blue in the RGB format
     * @param redValue Red value of the temperature
     * @param greenValue Green value of the temperature
     * @param blueValue Blue value of the temperature
     */
    public static void getRGBColor(int redValue, int greenValue, int blueValue)
    {
        System.out.printf("RGB color is :(%d,%d,%d)%n",redValue,greenValue,blueValue);
    }

    /**
     * Calculates the color value of the particular temperature using its
     * red, green and blue values.
     * @param redValue Red value of the temperature
     * @param greenValue Green value of the temperature
     * @param blueValue Blue value of the temperature
     * @return Returns the color value of the particular temperature.
     */
    public static int getColorValue (int redValue, int greenValue, int blueValue)
    {
        return ((COLOR_NUMBER_MULTIPLICAND_ONE * redValue) +
                (COLOR_NUMBER_MULTIPLICAND_TWO * greenValue)
                + blueValue);

    }

    /**
     * Finds the Hex value of the given integer passed
     * @param value integer value to be converted to Hex
     * @return returns the Hex value of the integer.
     */
    public static String getHexValue (int value)
    {
        return Integer.toHexString(value);
    }

    /**
     * Displays the Hex code of the RGB values
     * @param redValue Red value of the temperature
     * @param greenValue Green value of the temperature
     * @param blueValue Blue value of the temperature
     */
    public static void getHexCode (int redValue, int greenValue, int blueValue)
    {
        var hexRedValue = getHexValue(redValue);
        var hexGreenValue = getHexValue(greenValue);
        var hexBlueValue = getHexValue(blueValue);

        System.out.printf ("The Hex code is : #%s%s%s%n",hexRedValue,hexGreenValue,hexBlueValue);
    }

    public static void main(String[] args)
    {
        var scanner = new Scanner(System.in);
        String choice = "y";

        while (!choice.equalsIgnoreCase("Q"))
        {
            var temperature = getValidTemperature("Enter valid temperature:",MIN_TEMPERATURE,MAX_TEMPERATURE);
            System.out.printf("Temperature is: %d%n",temperature);
            var valueZ = getValueZ(temperature);
            var redValue = getRedValue(temperature,valueZ);
            var greenValue = getGreenValue(temperature,valueZ);
            var blueValue = getBlueValue(temperature,valueZ);


            var colorNumber = getColorValue(redValue,greenValue,blueValue);
            System.out.printf("Color value is: %d%n",colorNumber);

            getRGBColor(redValue,greenValue,blueValue);
            getHexCode(redValue,greenValue,blueValue);

            System.out.print("Press 'Y' to continue, 'Q' to STOP: ");
            choice = scanner.next();
            System.out.println();
        }
    }
}
