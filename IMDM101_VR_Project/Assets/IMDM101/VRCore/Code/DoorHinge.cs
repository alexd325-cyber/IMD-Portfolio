using System.Collections;
using UnityEngine;

// Who says nothing rhymes with "orange?"

public class DoorHinge : Interaction
{
    public float swingTime = 1;

    bool isSwinging = false;
    bool isOpen = false;

    override protected void Activate()
    {
        if (!isSwinging)
        {
            isSwinging = true;

            StartCoroutine(Swing(isOpen ? 1 : -1));
        }
    }

    IEnumerator Swing(int sign)
    {
        float degreesLeft = 90;

        Vector3 point = transform.position;
        point.x -= 0.5f * transform.localScale.x;

        while (degreesLeft > 0)
        {
            float deltaDegrees = 90 * Time.deltaTime / swingTime;

            if (deltaDegrees > degreesLeft)
            {
                deltaDegrees = degreesLeft;
            }

            transform.Rotate(0, sign * deltaDegrees, 0);

            degreesLeft -= deltaDegrees;

            yield return null;
        }

        isOpen = !isOpen;
        isSwinging = false;
    }
}
