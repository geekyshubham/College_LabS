
char add(char x[], char y[], char sum[])

{

    if (strlen(x) == strlen(y))

    {

        int length = strlen(x), i;

        char carry = '0';

        for (i = length - 1; i >= 0; i--)

        {

            if (x[i] == '1' && y[i] == '1' && carry == '0')

            {

                carry = '1';

                sum[i] = '0';
            }

            else if (x[i] == '1' && y[i] == '1' && carry == '1')

            {

                carry = '1';

                sum[i] = '1';
            }

            else if (x[i] == '1' && y[i] == '0' && carry == '0')

            {

                carry = '0';

                sum[i] = '1';
            }

            else if (x[i] == '1' && y[i] == '0' && carry == '1')

            {

                carry = '1';

                sum[i] = '0';
            }

            else if (x[i] == '0' && y[i] == '1' && carry == '0')

            {

                carry = '0';

                sum[i] = '1';
            }

            else if (x[i] == '0' && y[i] == '1' && carry == '1')

            {

                carry = '1';

                sum[i] = '0';
            }

            else if (x[i] == '0' && y[i] == '0' && carry == '0')

            {

                carry = '0';

                sum[i] = '0';
            }

            else

            {

                carry = '0';

                sum[i] = '1';
            }
        }
    }

    
}


char complement(char a[], char res[])

{

    int length = strlen(a), i;

    for (i = 0; i < length - 1; i++)

    {

        if (a[i] == '0')

            res[i] = '1';

        else if (a[i] == '0')

            res[i] = '0';

        else

            res[i] = a[i];
    }
}
