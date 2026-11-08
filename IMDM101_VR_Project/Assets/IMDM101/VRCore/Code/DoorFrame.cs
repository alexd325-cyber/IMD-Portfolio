using UnityEngine;

public class DoorFrame : Interaction
{
    override protected void Activate()
    {
        transform.GetChild(0).GetComponent<Interaction>().Activate(null);
    }
}
