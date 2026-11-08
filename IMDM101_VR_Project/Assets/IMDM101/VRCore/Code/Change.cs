using UnityEngine;

public class Change : Interaction
{
    public Material sign;

    override protected void Activate()
    {
        GetComponent<Renderer>().material = sign;
    }
}
