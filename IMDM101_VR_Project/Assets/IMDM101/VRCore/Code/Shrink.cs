using System.Collections;
using UnityEngine;

public class Shrink : Interaction
{
    public float shrinkTime = 1;
    bool isAlive = true;
    override protected void Activate()
    {
        if (isAlive)
        {
            isAlive = false;

            StartCoroutine(ShrinkAway());
        }
    }

    IEnumerator ShrinkAway()
    {
        float timeLeft = shrinkTime;

        Vector3 scale = transform.localScale;

        while (timeLeft > 0)
        {
            Debug.Log(timeLeft);
            timeLeft = timeLeft - Time.deltaTime / shrinkTime;

            if (timeLeft < 0)
            {
                timeLeft = 0;
            }

            transform.localScale = timeLeft / shrinkTime * scale;

            yield return null;
        }
    }
}
