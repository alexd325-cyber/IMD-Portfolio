using UnityEngine;

public class Highlight : Interaction
{
    public Color color = Color.hotPink;

    Color oldColor;
    protected override void HoverEnter()
    {
        oldColor = GetComponent<Renderer>().material.color;
        GetComponent<Renderer>().material.color = color;
    }
    protected override void HoverExit()
    {
        GetComponent<Renderer>().material.color = oldColor;
    }
}
